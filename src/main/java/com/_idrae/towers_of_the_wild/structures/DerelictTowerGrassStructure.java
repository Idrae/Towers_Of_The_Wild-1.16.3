package com._idrae.towers_of_the_wild.structures;

import com.mojang.serialization.Codec;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.JigsawStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class DerelictTowerGrassStructure extends JigsawStructure {
    public DerelictTowerGrassStructure(Codec<VillageConfig> p_i241978_1_, int p_i241978_2_, boolean p_i241978_3_, boolean p_i241978_4_) {
        super(p_i241978_1_, p_i241978_2_, p_i241978_3_, p_i241978_4_);
    }

    @Override
    protected boolean func_230363_a_(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_, SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_, Biome p_230363_8_, ChunkPos p_230363_9_, VillageConfig p_230363_10_) {
        return super.func_230363_a_(p_230363_1_, p_230363_2_, p_230363_3_, p_230363_5_, p_230363_6_, p_230363_7_, p_230363_8_, p_230363_9_, p_230363_10_);
    }
}
