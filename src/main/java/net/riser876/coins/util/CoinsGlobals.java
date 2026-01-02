package net.riser876.coins.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoinsGlobals {

    public static final String MOD_ID = "coins";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static ResourceKey<Item> keyOf(String itemId) {
        return ResourceKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(CoinsGlobals.MOD_ID, itemId));
    }
}
