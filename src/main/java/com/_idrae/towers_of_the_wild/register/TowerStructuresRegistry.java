package com._idrae.towers_of_the_wild.register;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com._idrae.towers_of_the_wild.structures.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class TowerStructuresRegistry {

    // Structures
    public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, TowersOfTheWild.MOD_ID);

    public static final RegistryObject<Structure<VillageConfig>> TOWER = register("tower", new TowerStructure(VillageConfig.field_236533_a_));
    public static final RegistryObject<Structure<VillageConfig>> ICE_TOWER = register("ice_tower", new IceTowerStructure(VillageConfig.field_236533_a_));
    public static final RegistryObject<Structure<VillageConfig>> JUNGLE_TOWER = register("jungle_tower", new JungleTowerStructure(VillageConfig.field_236533_a_));
    public static final RegistryObject<Structure<VillageConfig>> DERELICT_TOWER = register("derelict_tower", new DerelictTowerStructure(VillageConfig.field_236533_a_));
    public static final RegistryObject<Structure<VillageConfig>> DERELICT_GRASS_TOWER = register("derelict_grass_tower", new DerelictGrassTowerStructure(VillageConfig.field_236533_a_));
    public static final RegistryObject<Structure<VillageConfig>> OCEAN_TOWER = register("ocean_tower", new OceanTowerStructure(VillageConfig.field_236533_a_));
    public static final RegistryObject<Structure<VillageConfig>> OCEAN_WARM_TOWER = register("ocean_warm_tower", new OceanWarmTowerStructure(VillageConfig.field_236533_a_));

    private static <T extends Structure<?>> RegistryObject<T> register(String name, T structure) {
        TowersOfTheWild.LOGGER.info(name + " structure registered");
        Structure.NAME_STRUCTURE_BIMAP.put(TowersOfTheWild.MOD_ID + ":" + name, structure);
        Structure.STRUCTURE_DECORATION_STAGE_MAP.put(structure, GenerationStage.Decoration.SURFACE_STRUCTURES);

        return STRUCTURE_FEATURES.register(name, () -> structure);
    }
}
