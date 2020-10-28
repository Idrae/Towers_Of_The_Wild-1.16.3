package com._idrae.towers_of_the_wild.structures.pieces;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.structure.VillagesPools;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessorList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TowerPools {

    public static final JigsawPattern PATTERN = JigsawPatternRegistry.func_244094_a(
            new JigsawPattern(
                    new ResourceLocation(TowersOfTheWild.MOD_ID),
                    new ResourceLocation("empty"),
                    ImmutableList.of(Pair.of(JigsawPiece.func_242851_a(TowersOfTheWild.MOD_ID + ":tower_bottom_jigsaw", ProcessorLists.field_244101_a), 1)),
                    JigsawPattern.PlacementBehaviour.RIGID)
            );


    static {

        JigsawPatternRegistry.func_244094_a(
                new JigsawPattern(
                        new ResourceLocation(TowersOfTheWild.MOD_ID),
                        new ResourceLocation("empty"),
                        ImmutableList.of(Pair.of(JigsawPiece.func_242851_a(TowersOfTheWild.MOD_ID + ":tower_top_jigsaw", ProcessorLists.field_244101_a), 1)),
                        JigsawPattern.PlacementBehaviour.RIGID)
                );

    }
}
