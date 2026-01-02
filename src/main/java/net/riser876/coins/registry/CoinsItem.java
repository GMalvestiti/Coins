package net.riser876.coins.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.riser876.coins.util.CoinsGlobals;

import java.util.function.Supplier;

public class CoinsItem {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CoinsGlobals.MOD_ID);

    public static final DeferredItem<Item> GOLD_COIN = register(CoinId.GOLD_COIN.getId());
    public static final DeferredItem<Item> IRON_COIN = register(CoinId.IRON_COIN.getId());
    public static final DeferredItem<Item> COPPER_COIN = register(CoinId.COPPER_COIN.getId());

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CoinsGlobals.MOD_ID);

    public static final Supplier<CreativeModeTab> COINS_TAB = CREATIVE_MODE_TABS.register(CoinsGlobals.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + CoinsGlobals.MOD_ID))
            .icon(() -> new ItemStack(CoinsItem.GOLD_COIN.get()))
            .displayItems((params, output) -> {
                output.accept(CoinsItem.GOLD_COIN.get());
                output.accept(CoinsItem.IRON_COIN.get());
                output.accept(CoinsItem.COPPER_COIN.get());
            }).build()
    );

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    public static DeferredItem<Item> register(String identifier) {
        return ITEMS.registerSimpleItem(identifier);
    }
}
