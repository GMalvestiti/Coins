package net.riser876.coins.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.riser876.coins.item.CoinsItem;
import net.riser876.coins.registry.CoinsTag;

import java.util.concurrent.CompletableFuture;

public class CoinsEnglishLanguageProvider extends FabricLanguageProvider {

    public CoinsEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(CoinsItem.COINS_ITEM_GROUP_KEY, "Coins");

        translationBuilder.add(CoinsItem.GOLD_COIN, "Gold Coin");
        translationBuilder.add(CoinsItem.IRON_COIN, "Iron Coin");
        translationBuilder.add(CoinsItem.COPPER_COIN, "Copper Coin");

        translationBuilder.add(CoinsTag.COINS, "Coins");
        translationBuilder.add(CoinsTag.GOLD_COIN, "Gold Coin");
        translationBuilder.add(CoinsTag.IRON_COIN, "Iron Coin");
        translationBuilder.add(CoinsTag.COPPER_COIN, "Copper Coin");
    }
}
