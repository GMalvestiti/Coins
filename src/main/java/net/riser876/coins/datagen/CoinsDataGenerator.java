package net.riser876.coins.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.riser876.coins.datagen.provider.CoinsBrazilianPortugueseLanguageProvider;
import net.riser876.coins.datagen.provider.CoinsEnglishLanguageProvider;
import net.riser876.coins.datagen.provider.CoinsItemTagProvider;
import net.riser876.coins.datagen.provider.CoinsModelProvider;
import net.riser876.coins.util.CoinsGlobals;

public class CoinsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CoinsItemTagProvider::new);
        pack.addProvider(CoinsModelProvider::new);
        pack.addProvider(CoinsEnglishLanguageProvider::new);
        pack.addProvider(CoinsBrazilianPortugueseLanguageProvider::new);
    }

    @Override
    public String getEffectiveModId() {
        return CoinsGlobals.MOD_ID;
    }
}
