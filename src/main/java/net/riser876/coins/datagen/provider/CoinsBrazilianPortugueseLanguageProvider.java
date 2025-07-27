package net.riser876.coins.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.riser876.coins.item.CoinsItem;
import net.riser876.coins.registry.CoinsTag;

import java.util.concurrent.CompletableFuture;

public class CoinsBrazilianPortugueseLanguageProvider extends FabricLanguageProvider {

    public CoinsBrazilianPortugueseLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "pt_br", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(CoinsItem.COINS_ITEM_GROUP_KEY, "Moedas");

        translationBuilder.add(CoinsItem.GOLD_COIN, "Moeda de Ouro");
        translationBuilder.add(CoinsItem.IRON_COIN, "Moeda de Ferro");
        translationBuilder.add(CoinsItem.COPPER_COIN, "Moeda de Cobre");

        translationBuilder.add(CoinsTag.COINS, "Moedas");
        translationBuilder.add(CoinsTag.GOLD_COIN, "Moeda de Ouro");
        translationBuilder.add(CoinsTag.IRON_COIN, "Moeda de Ferro");
        translationBuilder.add(CoinsTag.COPPER_COIN, "Moeda de Cobre");
    }
}
