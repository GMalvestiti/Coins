package net.riser876.coins.datagen.provider;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.riser876.coins.registry.CoinsItem;
import net.riser876.coins.util.CoinsGlobals;

public class CoinsModelProvider extends ModelProvider {

    public CoinsModelProvider(PackOutput output) {
        super(output, CoinsGlobals.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(CoinsItem.GOLD_COIN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CoinsItem.IRON_COIN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CoinsItem.COPPER_COIN.get(), ModelTemplates.FLAT_ITEM);
    }
}
