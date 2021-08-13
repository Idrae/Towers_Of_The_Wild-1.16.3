package com._idrae.towers_of_the_wild.setup;

import com._idrae.towers_of_the_wild.register.TowerStructuresRegistry;
import com._idrae.towers_of_the_wild.structures.AbstractTowerStructure;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;

public class WorldSetup {

    public static void setup() {

        for (RegistryObject<Structure<?>> ro : TowerStructuresRegistry.STRUCTURE_FEATURES.getEntries()) {
            AbstractTowerStructure structure = (AbstractTowerStructure) ro.get();
            DimensionStructuresSettings.field_236191_b_ = // Default structures
                    ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                            .putAll(DimensionStructuresSettings.field_236191_b_)
                            .put(structure, new StructureSeparationSettings(structure.getDistance(), structure.getSeparation(), structure.getSeedModifier()))
                            .build();

            DimensionSettings.DEFAULT_SETTINGS.getStructures().field_236193_d_.put(structure, new StructureSeparationSettings(structure.getDistance(), structure.getSeparation(), structure.getSeedModifier()));
        }


    }

}
