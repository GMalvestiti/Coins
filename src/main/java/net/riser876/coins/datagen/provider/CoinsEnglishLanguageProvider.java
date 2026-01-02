package net.riser876.coins.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.riser876.coins.registry.CoinsItem;
import net.riser876.coins.registry.CoinsTag;
import net.riser876.coins.util.CoinsGlobals;

public class CoinsEnglishLanguageProvider extends LanguageProvider {

    public CoinsEnglishLanguageProvider(PackOutput output) {
        super(output, CoinsGlobals.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemgroup." + CoinsGlobals.MOD_ID, "Coins");

        addItem(CoinsItem.GOLD_COIN, "Gold Coin");
        addItem(CoinsItem.IRON_COIN, "Iron Coin");
        addItem(CoinsItem.COPPER_COIN, "Copper Coin");

        add(CoinsTag.COINS, "Coins");
        add(CoinsTag.GOLD_COIN, "Gold Coin");
        add(CoinsTag.IRON_COIN, "Iron Coin");
        add(CoinsTag.COPPER_COIN, "Copper Coin");
    }
}
