package net.riser876.coins.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.riser876.coins.registry.CoinsItem;

public class CoinsModelProvider extends FabricModelProvider {

    public CoinsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemGenerated(itemModelGenerator, CoinsItem.GOLD_COIN);
        itemGenerated(itemModelGenerator, CoinsItem.IRON_COIN);
        itemGenerated(itemModelGenerator, CoinsItem.COPPER_COIN);
    }

    private static void itemGenerated(ItemModelGenerators itemModelGenerator, Item item) {
        itemModelGenerator.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }
}
