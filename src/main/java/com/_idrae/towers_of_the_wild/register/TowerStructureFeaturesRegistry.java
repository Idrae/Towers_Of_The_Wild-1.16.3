package com._idrae.towers_of_the_wild.register;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com._idrae.towers_of_the_wild.structures.pieces.*;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.PlainsVillagePools;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class TowerStructureFeaturesRegistry {

    // Structure Features
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> TOWER_FEATURE = register("tower", TowerStructuresRegistry.TOWER.get().withConfiguration(new VillageConfig(() -> TowerPools.BOTTOM, 7)));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> ICE_TOWER_FEATURE = register("ice_tower", TowerStructuresRegistry.ICE_TOWER.get().withConfiguration(new VillageConfig(() -> IceTowerPools.BOTTOM, 7)));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> JUNGLE_TOWER_FEATURE = register("jungle_tower", TowerStructuresRegistry.JUNGLE_TOWER.get().withConfiguration(new VillageConfig(() -> JungleTowerPools.BOTTOM, 7)));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> DERELICT_TOWER_FEATURE = register("derelict_tower", TowerStructuresRegistry.DERELICT_TOWER.get().withConfiguration(new VillageConfig(() -> DerelictTowerPools.BOTTOM, 7)));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> DERELICT_GRASS_TOWER_FEATURE = register("derelict_grass_tower", TowerStructuresRegistry.DERELICT_GRASS_TOWER.get().withConfiguration(new VillageConfig(() -> DerelictGrassTowerPools.BOTTOM, 7)));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> OCEAN_TOWER_FEATURE = register("ocean_tower", TowerStructuresRegistry.OCEAN_TOWER.get().withConfiguration(new VillageConfig(() -> OceanTowerPools.BOTTOM, 7)));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> OCEAN_WARM_TOWER_FEATURE = register("ocean_warm_tower", TowerStructuresRegistry.OCEAN_WARM_TOWER.get().withConfiguration(new VillageConfig(() -> OceanWarmTowerPools.BOTTOM, 7)));

    private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structureFeature) {
        TowersOfTheWild.LOGGER.info(name + " structure feature registered");
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, name, structureFeature);
    }
}
