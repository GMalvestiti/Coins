package net.riser876.coins.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.riser876.coins.item.CoinsItem;
import net.riser876.coins.registry.CoinsTag;

import java.util.concurrent.CompletableFuture;

public class CoinsTagProvider extends FabricTagProvider<Item> {

    public CoinsTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(CoinsTag.GOLD_COIN)
                .add(CoinsItem.GOLD_COIN)
                .setReplace(false);

        getOrCreateTagBuilder(CoinsTag.IRON_COIN)
                .add(CoinsItem.IRON_COIN)
                .setReplace(false);

        getOrCreateTagBuilder(CoinsTag.COPPER_COIN)
                .add(CoinsItem.COPPER_COIN)
                .setReplace(false);

        getOrCreateTagBuilder(CoinsTag.COINS)
                .addOptionalTag(CoinsTag.GOLD_COIN)
                .addOptionalTag(CoinsTag.IRON_COIN)
                .addOptionalTag(CoinsTag.COPPER_COIN)
                .setReplace(false);
    }
}
