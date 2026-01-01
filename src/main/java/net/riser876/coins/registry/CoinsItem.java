package net.riser876.coins.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.riser876.coins.util.CoinsGlobals;

import static net.riser876.coins.util.CoinsGlobals.keyOf;

public class CoinsItem {

    public static final ResourceKey<CreativeModeTab> COINS_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(CoinsGlobals.MOD_ID, "item_group"));
    public static final CreativeModeTab COINS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CoinsItem.GOLD_COIN))
            .title(Component.translatable("itemgroup.coins"))
            .build();

    public static final Item GOLD_COIN = register(CoinId.GOLD_COIN.getId());
    public static final Item IRON_COIN = register(CoinId.IRON_COIN.getId());
    public static final Item COPPER_COIN = register(CoinId.COPPER_COIN.getId());

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, COINS_ITEM_GROUP_KEY, COINS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(COINS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(CoinsItem.GOLD_COIN);
            itemGroup.accept(CoinsItem.IRON_COIN);
            itemGroup.accept(CoinsItem.COPPER_COIN);
        });
    }

    private static Item register(String itemId) {
        return register(keyOf(itemId), new Item.Properties());
    }

    private static Item register(ResourceKey<Item> itemKey, Item.Properties settings) {
        return Registry.register(BuiltInRegistries.ITEM, itemKey, new Item(settings));
    }
}
