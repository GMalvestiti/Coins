package net.riser876.coins.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.riser876.coins.registry.CoinId;
import net.riser876.coins.registry.CoinsTag;

import java.util.concurrent.CompletableFuture;

import static net.riser876.coins.util.CoinsGlobals.keyOf;

public class CoinsTagProvider extends FabricTagProvider.ItemTagProvider {

    public CoinsTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(CoinsTag.GOLD_COIN).add(keyOf(CoinId.GOLD_COIN.getId()));

        tag(CoinsTag.IRON_COIN).add(keyOf(CoinId.IRON_COIN.getId()));

        tag(CoinsTag.COPPER_COIN).add(keyOf(CoinId.COPPER_COIN.getId()));

        tag(CoinsTag.COINS)
                .addOptionalTag(CoinsTag.GOLD_COIN.location())
                .addOptionalTag(CoinsTag.IRON_COIN.location())
                .addOptionalTag(CoinsTag.COPPER_COIN.location());
    }
}
