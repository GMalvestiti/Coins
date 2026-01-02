package net.riser876.coins.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.riser876.coins.registry.CoinsItem;
import net.riser876.coins.util.CoinsGlobals;

public class CoinsItemModelProvider extends ItemModelProvider {

    public CoinsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CoinsGlobals.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CoinsItem.GOLD_COIN.get());
        basicItem(CoinsItem.IRON_COIN.get());
        basicItem(CoinsItem.COPPER_COIN.get());
    }
}
