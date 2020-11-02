package com._idrae.towers_of_the_wild.structures;

import com._idrae.towers_of_the_wild.config.TowersOfTheWildConfig;
import com._idrae.towers_of_the_wild.register.TowerStructuresRegistry;
import com._idrae.towers_of_the_wild.structures.pieces.DerelictGrassTowerPools;
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
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraftforge.fml.RegistryObject;

import java.util.Objects;

public class DerelictGrassTowerStructure extends AbstractTowerStructure {

    public DerelictGrassTowerStructure(Codec<VillageConfig> p_i231997_1_) {
        super(p_i231997_1_);
    }

    @Override
    public int getSeedModifier() {
        return 1689781;
    }

    @Override
    public int getSize() {
        return 18;
    }

    @Override
    public int getDistance() {
        return TowersOfTheWildConfig.derelictRarity;
    }

    @Override
    public int getSeparation() {
        return TowersOfTheWildConfig.derelictRarity / 3;
    }

    @Override
    protected boolean isTerrainFlat(ChunkGenerator generator, int chunkX, int chunkZ) {

        int offset = getSize();

        int xStart = chunkX * 16;
        int zStart = chunkZ * 16;

        int i1 = generator.getHeight(xStart, zStart, Heightmap.Type.WORLD_SURFACE_WG);
        int j1 = generator.getHeight(xStart, zStart + offset, Heightmap.Type.WORLD_SURFACE_WG);
        int k1 = generator.getHeight(xStart + offset, zStart, Heightmap.Type.WORLD_SURFACE_WG);
        int l1 = generator.getHeight(xStart + offset, zStart + offset, Heightmap.Type.WORLD_SURFACE_WG);
        int m1 = generator.getHeight(xStart + offset / 2, zStart + offset / 2, Heightmap.Type.WORLD_SURFACE_WG);
        int minHeight = Math.min(Math.min(Math.min(i1, j1), Math.min(k1, l1)), m1);
        int maxHeight = Math.max(Math.max(Math.max(i1, j1), Math.max(k1, l1)), m1);

        return Math.abs(maxHeight - minHeight) <= 4;
    }

    @Override
    protected boolean alreadyIsTower(ChunkGenerator generator, AbstractTowerStructure structure, long seed, SharedSeedRandom rand, int chunkX, int chunkZ) {
        for (int k = chunkX - TowersOfTheWildConfig.rarity / 6; k <= chunkX + TowersOfTheWildConfig.rarity / 6; ++k) {
            for (int l = chunkZ - TowersOfTheWildConfig.rarity / 6; l <= chunkZ + TowersOfTheWildConfig.rarity / 6; ++l) {
                for (RegistryObject<Structure<?>> ro : TowerStructuresRegistry.STRUCTURE_FEATURES.getEntries()) {
                    Structure<?> otherStructure = ro.get();
                    if (!structure.equals(otherStructure)) {
                        ChunkPos otherStructurePos = otherStructure.func_236392_a_(Objects.requireNonNull(generator.func_235957_b_().func_236197_a_(otherStructure)), seed, rand, k, l);
                        if (k == otherStructurePos.x && l == otherStructurePos.z) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public IStartFactory<VillageConfig> getStartFactory() {
        return DerelictGrassTowerStructure.Start::new;
    }

    public static class Start extends MarginedStructureStart<VillageConfig> {
        public Start(Structure<VillageConfig> structure, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox boundingBox, int p_i225876_5_, long p_i225876_6_) {
            super(structure, p_i225876_2_, p_i225876_3_, boundingBox, p_i225876_5_, p_i225876_6_);
        }

        // generate
        public void func_230364_a_(DynamicRegistries registries, ChunkGenerator generator, TemplateManager manager, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, VillageConfig villageConfig) {
            int i = p_230364_4_ * 16;
            int j = p_230364_5_ * 16;
            if (!DerelictGrassTowerPools.registered) {
                DerelictGrassTowerPools.init(registries);
            }
            BlockPos blockpos = new BlockPos(i, 0, j);
            JigsawManager.func_242837_a(registries, villageConfig, AbstractVillagePiece::new, generator, manager, blockpos, this.components, this.rand, true, true);
            this.recalculateStructureSize();

        }
    }
}
