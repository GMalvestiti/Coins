package net.riser876.coins.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.riser876.coins.registry.CoinsItem;
import net.riser876.coins.registry.CoinsTag;
import net.riser876.coins.util.CoinsGlobals;

public class CoinsBrazilianPortugueseLanguageProvider extends LanguageProvider {

    public CoinsBrazilianPortugueseLanguageProvider(PackOutput output) {
        super(output, CoinsGlobals.MOD_ID, "pt_br");
    }

    @Override
    protected void addTranslations() {
        add("itemgroup." + CoinsGlobals.MOD_ID, "Moedas");

        addItem(CoinsItem.GOLD_COIN, "Moeda de Ouro");
        addItem(CoinsItem.IRON_COIN, "Moeda de Ferro");
        addItem(CoinsItem.COPPER_COIN, "Moeda de Cobre");

        add(CoinsTag.COINS, "Moedas");
        add(CoinsTag.GOLD_COIN, "Moeda de Ouro");
        add(CoinsTag.IRON_COIN, "Moeda de Ferro");
        add(CoinsTag.COPPER_COIN, "Moeda de Cobre");
    }
}
