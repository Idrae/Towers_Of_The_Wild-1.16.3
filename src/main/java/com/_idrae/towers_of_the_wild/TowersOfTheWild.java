package com._idrae.towers_of_the_wild;

import com._idrae.towers_of_the_wild.config.TowersOfTheWildConfig;
import com._idrae.towers_of_the_wild.register.TowerStructureFeaturesRegistry;
import com._idrae.towers_of_the_wild.register.TowerStructuresRegistry;
import com._idrae.towers_of_the_wild.setup.WorldSetup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("towers_of_the_wild")
public class TowersOfTheWild {
    public static final String MOD_ID = "towers_of_the_wild";
    public static final Logger LOGGER = LogManager.getLogger();

    public TowersOfTheWild() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TowersOfTheWildConfig.COMMON_SPEC);
        TowerStructuresRegistry.STRUCTURE_FEATURES.register(modEventBus);
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        WorldSetup.setup();
        TowerStructureFeaturesRegistry.registerJigsawPatterns();
        TowerStructureFeaturesRegistry.registerStructureFeatures();
    }
}
