package com._idrae.towers_of_the_wild.events;

import com._idrae.towers_of_the_wild.register.TowerStructureFeatures;
import com._idrae.towers_of_the_wild.register.TowersOfTheWildRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class TowersOfTheWildEventSubscriber {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoaded(BiomeLoadingEvent event) {
        ResourceLocation name = event.getName();
        Biome.Category category = event.getCategory();
        event.getGeneration().withStructure(TowerStructureFeatures.TOWER_FEATURE);
    }

}

