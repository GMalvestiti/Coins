package net.riser876.coins.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.riser876.coins.registry.CoinsItem;
import net.riser876.coins.registry.CoinsTag;
import net.riser876.coins.util.CoinsGlobals;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CoinsItemTagProvider extends ItemTagsProvider {

    public CoinsItemTagProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider,
                                CompletableFuture<TagsProvider.TagLookup<Block>> blockTagLookup) {
        super(output, lookupProvider, blockTagLookup, CoinsGlobals.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
        tag(CoinsTag.GOLD_COIN).add(CoinsItem.GOLD_COIN.get());

        tag(CoinsTag.IRON_COIN).add(CoinsItem.IRON_COIN.get());

        tag(CoinsTag.COPPER_COIN).add(CoinsItem.COPPER_COIN.get());

        tag(CoinsTag.COINS)
                .addOptionalTag(CoinsTag.GOLD_COIN)
                .addOptionalTag(CoinsTag.IRON_COIN)
                .addOptionalTag(CoinsTag.COPPER_COIN);
    }
}
