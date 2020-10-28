package com._idrae.towers_of_the_wild.structures;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class AbstractTowerStructure extends JigsawStructure {

    public AbstractTowerStructure(Codec<VillageConfig> p_i231997_1_) {
        super(p_i231997_1_, 0, true, true);

    }

    public String getName() {
        return "tower";
    }

    public int getDistance() {
        return 5;
    }

    public int getSeparation() {
        return 2;
    }

    public int getSeedModifier() {
        return 16897777;
    }

    @Override
    public IStartFactory<VillageConfig> getStartFactory() {
        return AbstractTowerStructure.Start::new;
    }

    public static class Start extends MarginedStructureStart<VillageConfig> {
        public Start(Structure<VillageConfig> structure, int p_i225876_2_, int p_i225876_3_, MutableBoundingBox boundingBox, int p_i225876_5_, long p_i225876_6_) {
            super(structure, p_i225876_2_, p_i225876_3_, boundingBox, p_i225876_5_, p_i225876_6_);
        }

        public void func_230364_a_(DynamicRegistries registries, ChunkGenerator generator, TemplateManager manager, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, VillageConfig villageConfig) {
            int i = p_230364_4_ * 16;
            int j = p_230364_5_ * 16;
            BlockPos blockpos = new BlockPos(i, 1, j);
            Rotation rotation = Rotation.randomRotation(this.rand);
            JigsawManager.func_242837_a(registries, villageConfig, AbstractVillagePiece::new, generator, manager, blockpos, this.components, this.rand, true, true);
            // JigsawManager.func_242837_a(registries, villageConfig, AbstractVillagePiece::new, generator, manager, blockpos.add(0, 50, 0), this.components, this.rand, true, true);
            this.recalculateStructureSize();
        }
    }


}
