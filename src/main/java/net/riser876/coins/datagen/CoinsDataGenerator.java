package net.riser876.coins.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.riser876.coins.Coins;
import net.riser876.coins.datagen.provider.CoinsBrazilianPortugueseLanguageProvider;
import net.riser876.coins.datagen.provider.CoinsEnglishLanguageProvider;
import net.riser876.coins.datagen.provider.CoinsRecipeProvider;
import net.riser876.coins.datagen.provider.CoinsTagProvider;
import net.riser876.coins.datagen.provider.CoinsModelProvider;

public class CoinsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CoinsTagProvider::new);
        pack.addProvider(CoinsModelProvider::new);
        pack.addProvider(CoinsEnglishLanguageProvider::new);
        pack.addProvider(CoinsBrazilianPortugueseLanguageProvider::new);
        pack.addProvider(CoinsRecipeProvider::new);
    }

    @Override
    public String getEffectiveModId() {
        return Coins.MOD_ID;
    }
}
