package net.riser876.coins.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.riser876.coins.Coins;

import java.util.function.Function;

public class CoinsItem {

    public static final RegistryKey<ItemGroup> COINS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Coins.MOD_ID, "item_group"));
    public static final ItemGroup COINS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CoinsItem.GOLD_COIN))
            .displayName(Text.translatable("itemgroup.coins"))
            .build();

    public static final Item GOLD_COIN = register(CoinsId.GOLD_COIN.getId());
    public static final Item IRON_COIN = register(CoinsId.IRON_COIN.getId());
    public static final Item COPPER_COIN = register(CoinsId.COPPER_COIN.getId());

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, COINS_ITEM_GROUP_KEY, COINS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(COINS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CoinsItem.GOLD_COIN);
            itemGroup.add(CoinsItem.IRON_COIN);
            itemGroup.add(CoinsItem.COPPER_COIN);
        });
    }

    public static Item register(String identifier) {
        return register(identifier, Item::new, new Item.Settings());
    }

    public static Item register(String identifier, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Coins.MOD_ID, identifier));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}
