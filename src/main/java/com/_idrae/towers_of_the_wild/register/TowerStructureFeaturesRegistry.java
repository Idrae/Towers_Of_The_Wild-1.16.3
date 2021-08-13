package com._idrae.towers_of_the_wild.register;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com._idrae.towers_of_the_wild.structures.pieces.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class TowerStructureFeaturesRegistry {

    // Structure Features
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> TOWER_FEATURE = TowerStructuresRegistry.TOWER.get().withConfiguration(new VillageConfig(() -> TowerPools.BOTTOM, 7));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> ICE_TOWER_FEATURE = TowerStructuresRegistry.ICE_TOWER.get().withConfiguration(new VillageConfig(() -> IceTowerPools.BOTTOM, 7));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> JUNGLE_TOWER_FEATURE = TowerStructuresRegistry.JUNGLE_TOWER.get().withConfiguration(new VillageConfig(() -> JungleTowerPools.BOTTOM, 7));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> DERELICT_TOWER_FEATURE = TowerStructuresRegistry.DERELICT_TOWER.get().withConfiguration(new VillageConfig(() -> DerelictTowerPools.BOTTOM, 7));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> DERELICT_GRASS_TOWER_FEATURE = TowerStructuresRegistry.DERELICT_GRASS_TOWER.get().withConfiguration(new VillageConfig(() -> DerelictGrassTowerPools.BOTTOM, 7));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> OCEAN_TOWER_FEATURE = TowerStructuresRegistry.OCEAN_TOWER.get().withConfiguration(new VillageConfig(() -> OceanTowerPools.BOTTOM, 7));
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> OCEAN_WARM_TOWER_FEATURE = TowerStructuresRegistry.OCEAN_WARM_TOWER.get().withConfiguration(new VillageConfig(() -> OceanWarmTowerPools.BOTTOM, 7));

    public static void registerStructureFeatures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(TowersOfTheWild.MOD_ID, "tower"), TOWER_FEATURE);
        Registry.register(registry, new ResourceLocation(TowersOfTheWild.MOD_ID, "ice_tower"), ICE_TOWER_FEATURE);
        Registry.register(registry, new ResourceLocation(TowersOfTheWild.MOD_ID, "jungle_tower"), JUNGLE_TOWER_FEATURE);
        Registry.register(registry, new ResourceLocation(TowersOfTheWild.MOD_ID, "derelict_tower"), DERELICT_TOWER_FEATURE);
        Registry.register(registry, new ResourceLocation(TowersOfTheWild.MOD_ID, "derelict_grass_tower"), DERELICT_GRASS_TOWER_FEATURE);
        Registry.register(registry, new ResourceLocation(TowersOfTheWild.MOD_ID, "ocean_tower"), OCEAN_TOWER_FEATURE);
        Registry.register(registry, new ResourceLocation(TowersOfTheWild.MOD_ID, "ocean_warm_tower"), OCEAN_WARM_TOWER_FEATURE);
    }

    public static void registerJigsawPatterns() {
        JigsawRegistration.register(TowerPools.BOTTOM);
        JigsawRegistration.register(OceanWarmTowerPools.BOTTOM);
        JigsawRegistration.register(OceanTowerPools.BOTTOM);
        JigsawRegistration.register(JungleTowerPools.BOTTOM);
        JigsawRegistration.register(IceTowerPools.BOTTOM);
        JigsawRegistration.register(DerelictTowerPools.BOTTOM);
        JigsawRegistration.register(DerelictGrassTowerPools.BOTTOM);
    }
}
