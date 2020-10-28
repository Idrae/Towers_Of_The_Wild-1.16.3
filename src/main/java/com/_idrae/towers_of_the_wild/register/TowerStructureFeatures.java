package com._idrae.towers_of_the_wild.register;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com._idrae.towers_of_the_wild.structures.pieces.TowerPools;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class TowerStructureFeatures {

    // Structure Features
    public static StructureFeature<VillageConfig, ? extends Structure<VillageConfig>> TOWER_FEATURE = register("tower1", TowersOfTheWildRegistry.TOWER.get().func_236391_a_(new VillageConfig(() -> TowerPools.PATTERN, 7)));

    private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structureFeature) {
        TowersOfTheWild.LOGGER.info(name + " structure feature registered");
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, name, structureFeature);
    }
}
