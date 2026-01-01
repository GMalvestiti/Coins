package net.riser876.coins.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.riser876.coins.util.CoinsGlobals;

public class CoinsTag {

    public static final TagKey<Item> COINS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(CoinsGlobals.MOD_ID, CoinsGlobals.MOD_ID));
    public static final TagKey<Item> GOLD_COIN = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(CoinsGlobals.MOD_ID, CoinId.GOLD_COIN.getId()));
    public static final TagKey<Item> IRON_COIN = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(CoinsGlobals.MOD_ID, CoinId.IRON_COIN.getId()));
    public static final TagKey<Item> COPPER_COIN = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(CoinsGlobals.MOD_ID, CoinId.COPPER_COIN.getId()));
}
