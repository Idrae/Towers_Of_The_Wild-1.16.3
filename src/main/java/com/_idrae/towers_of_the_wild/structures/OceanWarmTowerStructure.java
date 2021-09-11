package com._idrae.towers_of_the_wild.structures;

import com._idrae.towers_of_the_wild.config.TowersOfTheWildConfig;
import com._idrae.towers_of_the_wild.structures.pieces.OceanWarmTowerPools;
import com.mojang.serialization.Codec;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class OceanWarmTowerStructure extends AbstractTowerStructure {

    public OceanWarmTowerStructure(Codec<NoFeatureConfig> p_i231997_1_) {
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

    // can generate
    @Override
    protected boolean func_230363_a_(ChunkGenerator generator, BiomeProvider biomeProvider, long seed, SharedSeedRandom rand, int chunkX, int chunkZ, Biome biome, ChunkPos pos, NoFeatureConfig config) {
        if (isTerrainFlat(generator, chunkX, chunkZ)) {
            if (!alreadyIsTower(generator, this, seed, rand, chunkX, chunkZ)) {

                int xStart = chunkX * 16;
                int zStart = chunkZ * 16;
                int startHeight = generator.getHeight(xStart, zStart, Heightmap.Type.OCEAN_FLOOR_WG);
                return startHeight <= 38;
            }
        }
        return false;
    }

    @Override
    protected boolean alreadyIsTower(ChunkGenerator generator, AbstractTowerStructure structure, long seed, SharedSeedRandom rand, int chunkX, int chunkZ) {
        return false;
    }


    @Override
    public Structure.IStartFactory<NoFeatureConfig> getStartFactory() {
        return OceanWarmTowerStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structure, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox boundingBox, int p_i225876_5_, long p_i225876_6_) {
            super(structure, p_i225876_2_, p_i225876_3_, boundingBox, p_i225876_5_, p_i225876_6_);
        }

        // generate
        public void func_230364_a_(DynamicRegistries registries, ChunkGenerator generator, TemplateManager manager, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig villageConfig) {
            int i = p_230364_4_ * 16;
            int j = p_230364_5_ * 16;
            BlockPos blockpos = new BlockPos(i, generator.getHeight(i, j, Heightmap.Type.OCEAN_FLOOR_WG) - generator.getHeight(i, j, Heightmap.Type.WORLD_SURFACE_WG), j);
            JigsawManager.func_242837_a(registries, new VillageConfig(() -> OceanWarmTowerPools.BOTTOM, 10), AbstractVillagePiece::new, generator, manager, blockpos, this.components, this.rand, false, true);
            this.recalculateStructureSize();
        }
    }
}
