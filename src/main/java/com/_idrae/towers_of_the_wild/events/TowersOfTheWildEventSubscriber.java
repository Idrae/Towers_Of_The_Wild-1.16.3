package com._idrae.towers_of_the_wild.events;

import com._idrae.towers_of_the_wild.config.TowersOfTheWildConfig;
import com._idrae.towers_of_the_wild.register.TowerStructureFeaturesRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class TowersOfTheWildEventSubscriber {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoaded(BiomeLoadingEvent event) {

        ResourceLocation name = event.getName();
        Biome.Category category = event.getCategory();

        if (category.equals(Biome.Category.JUNGLE)) {
            event.getGeneration().withStructure(TowerStructureFeaturesRegistry.JUNGLE_TOWER_FEATURE);
            return;
        }

        if (category.equals(Biome.Category.ICY)) {
            event.getGeneration().withStructure(TowerStructureFeaturesRegistry.ICE_TOWER_FEATURE);
            return;
        }

        if (TowersOfTheWildConfig.spawnOceanTowers) {

            if (name.toString().equals("minecraft:deep_lukewarm_ocean")
                    || name.toString().equals("minecraft:deep_warm_ocean")) {
                event.getGeneration().withStructure(TowerStructureFeaturesRegistry.OCEAN_WARM_TOWER_FEATURE);
                return;
            }

            if (category.equals(Biome.Category.OCEAN)) {
                if (name.toString().contains("deep")) {
                    event.getGeneration().withStructure(TowerStructureFeaturesRegistry.OCEAN_TOWER_FEATURE);
                    return;
                }
            }
        }

        if (!category.equals(Biome.Category.OCEAN) && !category.equals(Biome.Category.NETHER) && !category.equals(Biome.Category.THEEND)) {
            if (!TowersOfTheWildConfig.allModBiomesBlackList.contains(name.getNamespace())) {
                if (!TowersOfTheWildConfig.biomeBlackList.contains(name.toString())) {
                    event.getGeneration().withStructure(TowerStructureFeaturesRegistry.TOWER_FEATURE);

                    if (category.equals(Biome.Category.TAIGA)
                            || category.equals(Biome.Category.EXTREME_HILLS)
                            || category.equals(Biome.Category.SAVANNA)
                            || category.equals(Biome.Category.PLAINS)
                            || category.equals(Biome.Category.FOREST)) {
                        event.getGeneration().withStructure(TowerStructureFeaturesRegistry.DERELICT_GRASS_TOWER_FEATURE);
                    } else {
                        event.getGeneration().withStructure(TowerStructureFeaturesRegistry.DERELICT_TOWER_FEATURE);
                    }
                }
            }
        }
    }

}

