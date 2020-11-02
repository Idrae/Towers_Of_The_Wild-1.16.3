package com._idrae.towers_of_the_wild.structures;

import com._idrae.towers_of_the_wild.config.TowersOfTheWildConfig;
import com._idrae.towers_of_the_wild.register.TowerStructuresRegistry;
import com._idrae.towers_of_the_wild.structures.pieces.OceanWarmTowerPools;
import com.mojang.serialization.Codec;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraftforge.fml.RegistryObject;

import java.util.Objects;

public class OceanWarmTowerStructure extends AbstractTowerStructure{

    public OceanWarmTowerStructure(Codec<VillageConfig> p_i231997_1_) {
        super(p_i231997_1_);
    }

    @Override
    public int getSeedModifier() {
        return 1689782;
    }

    @Override
    public int getSize() {
        return 7;
    }

    @Override
    public int getDistance() {
        return TowersOfTheWildConfig.oceanRarity;
    }

    @Override
    public int getSeparation() {
        return TowersOfTheWildConfig.oceanRarity / 3;
    }

    @Override
    protected boolean alreadyIsTower(ChunkGenerator generator, AbstractTowerStructure structure, long seed, SharedSeedRandom rand, int chunkX, int chunkZ) {
        return false;
    }


    @Override
    public Structure.IStartFactory<VillageConfig> getStartFactory() {
        return OceanWarmTowerStructure.Start::new;
    }

    public static class Start extends MarginedStructureStart<VillageConfig> {
        public Start(Structure<VillageConfig> structure, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox boundingBox, int p_i225876_5_, long p_i225876_6_) {
            super(structure, p_i225876_2_, p_i225876_3_, boundingBox, p_i225876_5_, p_i225876_6_);
        }

        // generate
        public void func_230364_a_(DynamicRegistries registries, ChunkGenerator generator, TemplateManager manager, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, VillageConfig villageConfig) {
            int i = p_230364_4_ * 16;
            int j = p_230364_5_ * 16;
            if (!OceanWarmTowerPools.registered) {
                OceanWarmTowerPools.init(registries);
            }
            BlockPos blockpos = new BlockPos(i, generator.getHeight(i, j, Heightmap.Type.OCEAN_FLOOR_WG) - generator.getHeight(i, j, Heightmap.Type.WORLD_SURFACE_WG), j);
            JigsawManager.func_242837_a(registries, villageConfig, AbstractVillagePiece::new, generator, manager, blockpos, this.components, this.rand, true, true);
            this.recalculateStructureSize();
        }
    }
}
