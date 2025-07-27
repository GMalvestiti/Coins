package net.riser876.coins.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.riser876.coins.item.CoinsItem;

public class CoinsModelProvider extends FabricModelProvider {

    public CoinsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemGenerated(itemModelGenerator, CoinsItem.GOLD_COIN);
        itemGenerated(itemModelGenerator, CoinsItem.IRON_COIN);
        itemGenerated(itemModelGenerator, CoinsItem.COPPER_COIN);
    }

    private static void itemGenerated(ItemModelGenerator itemModelGenerator, Item item) {
        itemModelGenerator.register(item, Models.GENERATED);
    }
}
