package com._idrae.towers_of_the_wild.structures;

import com._idrae.towers_of_the_wild.structures.pieces.TowerPools;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TowerStructure extends AbstractTowerStructure {

    public TowerStructure(Codec<NoFeatureConfig> p_i231997_1_) {
        super(p_i231997_1_);
    }

    @Override
    public int getSeedModifier() {
        return 1689777;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return TowerStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structure, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox boundingBox, int p_i225876_5_, long p_i225876_6_) {
            super(structure, p_i225876_2_, p_i225876_3_, boundingBox, p_i225876_5_, p_i225876_6_);
        }

        // generate
        public void func_230364_a_(DynamicRegistries registries, ChunkGenerator generator, TemplateManager manager, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig villageConfig) {
            int i = p_230364_4_ * 16;
            int j = p_230364_5_ * 16;
            BlockPos blockpos = new BlockPos(i, 0, j);
            JigsawManager.func_242837_a(registries, new VillageConfig(() -> TowerPools.BOTTOM, 10), AbstractVillagePiece::new, generator, manager, blockpos, this.components, this.rand, false, true);
            this.recalculateStructureSize();

        }
    }
}
