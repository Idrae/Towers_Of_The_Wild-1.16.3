package com._idrae.towers_of_the_wild.config;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

@Mod.EventBusSubscriber(modid = TowersOfTheWild.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TowersOfTheWildConfig {

    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    public static int rarity;
    public static int derelictRarity;
    public static boolean spawnOceanTowers;
    public static int oceanRarity;
    public static List<String> allModBiomesBlackList;
    public static List<String> biomeBlackList;
    public static boolean waystonesCompat;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(TowersOfTheWildConfig.CommonConfig::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == TowersOfTheWildConfig.COMMON_SPEC) {
            bakeConfig();
            TowersOfTheWild.LOGGER.info("Config set");
        }
    }

    public static void bakeConfig() {
        rarity = COMMON.towerRarity.get();
        derelictRarity = COMMON.derelictTowerRarity.get();
        spawnOceanTowers = COMMON.spawnOceanTowers.get();
        oceanRarity = COMMON.oceanTowerRarity.get();
        allModBiomesBlackList = COMMON.allModBiomesBlackList.get();
        biomeBlackList = COMMON.biomeBlackList.get();
        waystonesCompat = COMMON.waystonesCompat.get();
    }

    public static class CommonConfig {

        public final ForgeConfigSpec.IntValue towerRarity;
        public final ForgeConfigSpec.IntValue derelictTowerRarity;
        public final ForgeConfigSpec.BooleanValue spawnOceanTowers;
        public final ForgeConfigSpec.IntValue oceanTowerRarity;
        public final ForgeConfigSpec.ConfigValue<List<String>> allModBiomesBlackList;
        public final ForgeConfigSpec.ConfigValue<List<String>> biomeBlackList;
        public final ForgeConfigSpec.BooleanValue waystonesCompat;

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("towers");
            towerRarity = builder
                    .comment("How rarely the towers will spawn (low: common, high: rare). Default: 20")
                    .defineInRange("towerRarity", 20, 3, 200);
            derelictTowerRarity = builder
                    .comment("How rarely the derelict towers will spawn (low: common, high: rare). Default: 72")
                    .defineInRange("derelictTowerRarity", 72, 3, 200);
            spawnOceanTowers = builder
                    .comment("Make towers spawn in the ocean. Default: true")
                    .define("spawnOceanTowers", true);
            oceanTowerRarity = builder
                    .comment("How rarely the ocean towers will spawn (low: common, high: rare). Default: 32")
                    .defineInRange("oceanTowerRarity", 32, 3, 200);
            allModBiomesBlackList = builder
                    .comment("A list of mod ids. In each and every biome added by those mods, the towers will not spawn. Default : The Midnight.")
                    .define("allModBiomesBlackList",
                            Lists.newArrayList(
                                    "midnight",
                                    "the_bumblezone"
                            ));
            biomeBlackList = builder
                    .comment("A list of biomes where the towers will not spawn. Default: Rivers, Beaches")
                    .define("biomeBlackList",
                            Lists.newArrayList(
                                    "minecraft:river",
                                    "minecraft:frozen_river",
                                    "minecraft:beach",
                                    "minecraft:stone_shore",
                                    "minecraft:snowy_beach",
                                    "biomesoplenty:gravel_beach",
                                    "biomesoplenty:white_beach"
                            ));
            waystonesCompat = builder
                    .comment("If the Waytones mod is installed and this is set to true, towers will spawn with a waystone at the top. If the Waystone mod is not installed, this will have no effect. Default: true")
                    .define("waystonesCompat", true);

            builder.pop();
        }
    }
}
