package com._idrae.towers_of_the_wild;

import com._idrae.towers_of_the_wild.config.TowersOfTheWildConfig;
import com._idrae.towers_of_the_wild.register.TowersOfTheWildRegistry;
import com._idrae.towers_of_the_wild.setup.WorldSetup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.registry.RegistryHandler;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TowersOfTheWild.MOD_ID)
public class TowersOfTheWild
{
    public static final String MOD_ID = "towers_of_the_wild";
    public static final Logger LOGGER = LogManager.getLogger();

    public TowersOfTheWild() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TowersOfTheWildConfig.COMMON_SPEC);
        TowersOfTheWildRegistry.STRUCTURE_FEATURES.register(modEventBus);
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        WorldSetup.setup();
    }
}
