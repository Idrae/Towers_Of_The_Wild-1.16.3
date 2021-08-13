package com._idrae.towers_of_the_wild.register;

import com._idrae.towers_of_the_wild.TowersOfTheWild;
import com.mojang.serialization.Lifecycle;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;

public class JigsawRegistration {

    public static JigsawPattern register(JigsawPattern pattern) {
        TowersOfTheWild.LOGGER.info(pattern.getName() + " pattern registered.");
        return JigsawPatternRegistry.func_244094_a(pattern);
    }

    public static void registerPostSetup(JigsawPattern pattern, DynamicRegistries registries) {
        if (!registries.getRegistry(Registry.JIGSAW_POOL_KEY).containsKey(pattern.getName())) {
            registries.getRegistry(Registry.JIGSAW_POOL_KEY).register(RegistryKey.getOrCreateKey(Registry.JIGSAW_POOL_KEY, pattern.getName()), pattern, Lifecycle.stable());
        }
    }

}
