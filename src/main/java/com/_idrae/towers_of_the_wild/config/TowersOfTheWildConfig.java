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
    public static List<String> allModBiomesBlackList;
    public static List<String> biomeBlackList;
    public static int derelictTowerProportion;
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
        allModBiomesBlackList = COMMON.allModBiomesBlackList.get();
        biomeBlackList = COMMON.biomeBlackList.get();
        derelictTowerProportion = COMMON.derelictTowerProportion.get();
        waystonesCompat = COMMON.waystonesCompat.get();
    }

    public static class CommonConfig {

        public final ForgeConfigSpec.IntValue towerRarity;
        public final ForgeConfigSpec.ConfigValue<List<String>> allModBiomesBlackList;
        public final ForgeConfigSpec.ConfigValue<List<String>> biomeBlackList;
        public final ForgeConfigSpec.IntValue derelictTowerProportion;
        public final ForgeConfigSpec.BooleanValue waystonesCompat;

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("towers");
            towerRarity = builder
                    .comment("How rarely the towers will spawn (low: common, high: rare). Default: 35")
                    .defineInRange("towerRarity", 35, 10, 1000);

            allModBiomesBlackList = builder
                    .comment("A list of mod ids. In each and every biome added by those mods, the towers will not spawn. Default : The Midnight.")
                    .define("allModBiomesBlackList",
                            Lists.newArrayList(
                                    "midnight"
                            ));

            biomeBlackList = builder
                    .comment("A list of biomes where the towers will not spawn. Default: Oceans, Rivers, Beaches, Nether, End.")
                    .define("biomeBlackList",
                            Lists.newArrayList(
                                    "minecraft:ocean",
                                    "minecraft:deep_ocean",
                                    "minecraft:frozen_ocean",
                                    "minecraft:deep_frozen_ocean",
                                    "minecraft:cold_ocean",
                                    "minecraft:deep_cold_ocean",
                                    "minecraft:lukewarm_ocean",
                                    "minecraft:deep_lukewarm_ocean",
                                    "minecraft:warm_ocean",
                                    "minecraft:deep_warm_ocean",
                                    "minecraft:river",
                                    "minecraft:frozen_river",
                                    "minecraft:beach",
                                    "minecraft:stone_shore",
                                    "minecraft:snowy_beach",
                                    "minecraft:nether_wastes",
                                    "minecraft:soul_sand_valley",
                                    "minecraft:crimson_forest",
                                    "minecraft:warped_forest",
                                    "minecraft:basalt_deltas",
                                    "minecraft:the_end",
                                    "minecraft:small_end_islands",
                                    "minecraft:end_midlands",
                                    "minecraft:end_highlands",
                                    "minecraft:end_barrens",
                                    "minecraft:jungle",
                                    "biomesoplenty:gravel_beach",
                                    "biomesoplenty:white_beach",
                                    "biomesoplenty:ashen_inferno",
                                    "biomesoplenty:undergarden",
                                    "biomesoplenty:visceral_heap"
                            ));

            derelictTowerProportion = builder
                    .comment("The proportion of towers that will be derelict (in %). Default: 15")
                    .defineInRange("derelictTowerProportion", 15, 0, 100);

            waystonesCompat = builder
                    .comment("If the Waytones mod is installed and this is set to true, towers will spawn with a waystone at the top. If the Waystone mod is not installed, this will have no effect. Default: true")
                    .define("waystonesCompat", true);

            builder.pop();
        }
    }
}
