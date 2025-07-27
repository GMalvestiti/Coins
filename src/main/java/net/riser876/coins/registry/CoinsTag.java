package net.riser876.coins.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.riser876.coins.Coins;
import net.riser876.coins.item.CoinsId;

public class CoinsTag {

    public static final TagKey<Item> COINS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Coins.MOD_ID, Coins.MOD_ID));
    public static final TagKey<Item> GOLD_COIN = TagKey.of(RegistryKeys.ITEM, Identifier.of(Coins.MOD_ID, CoinsId.GOLD_COIN.getId()));
    public static final TagKey<Item> IRON_COIN = TagKey.of(RegistryKeys.ITEM, Identifier.of(Coins.MOD_ID, CoinsId.IRON_COIN.getId()));
    public static final TagKey<Item> COPPER_COIN = TagKey.of(RegistryKeys.ITEM, Identifier.of(Coins.MOD_ID, CoinsId.COPPER_COIN.getId()));
}
