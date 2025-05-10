package net.riser876.coins.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.riser876.coins.Coins;

public class CoinItems {

    public static final RegistryKey<ItemGroup> COINS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Coins.MOD_ID, "item_group"));
    public static final ItemGroup COINS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CoinItems.GOLD_COIN))
            .displayName(Text.translatable("itemgroup.coins"))
            .build();

    public static final Item GOLD_COIN = register("gold_coin");
    public static final Item IRON_COIN = register("iron_coin");
    public static final Item COPPER_COIN = register("copper_coin");

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, COINS_ITEM_GROUP_KEY, COINS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(COINS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CoinItems.GOLD_COIN);
            itemGroup.add(CoinItems.IRON_COIN);
            itemGroup.add(CoinItems.COPPER_COIN);
        });
    }

    private static Item register(String itemId) {
        Identifier identifier = Identifier.of(Coins.MOD_ID, itemId);

        return Registry.register(Registries.ITEM, identifier, new Item(new Item.Settings()));
    }
}
