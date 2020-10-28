package com._idrae.towers_of_the_wild.register;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com._idrae.towers_of_the_wild.structures.AbstractTowerStructure;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TowersOfTheWildRegistry {

    // Structures
    public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, TowersOfTheWild.MOD_ID);
    public static final RegistryObject<Structure<VillageConfig>> TOWER = registerStructure("tower", new AbstractTowerStructure(VillageConfig.field_236533_a_));

    private static <T extends Structure<?>> RegistryObject<T> registerStructure(String name, T structure) {
        TowersOfTheWild.LOGGER.info(name + " structure registered");
        Structure.field_236365_a_.put(TowersOfTheWild.MOD_ID + ":" + name, structure);
        Structure.field_236385_u_.put(structure, GenerationStage.Decoration.SURFACE_STRUCTURES);

        return STRUCTURE_FEATURES.register(name, () -> structure);
    }

    /*
    public static void registerPieces() {
        registerPiece("tower", TOWER_PIECE);
    }

    // Structure Pieces
    public static final IStructurePieceType TOWER_PIECE = AbstractTowerPieces.Piece::new;

    private static void registerPiece(String key, IStructurePieceType type) {
        TowersOfTheWild.LOGGER.info(key + " structure piece registered");
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(TowersOfTheWild.MOD_ID, key), type);
    }

     */
}
