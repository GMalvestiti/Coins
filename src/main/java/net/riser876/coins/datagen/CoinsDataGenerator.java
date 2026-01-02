package net.riser876.coins.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.riser876.coins.datagen.provider.CoinsBlockTagProvider;
import net.riser876.coins.datagen.provider.CoinsBrazilianPortugueseLanguageProvider;
import net.riser876.coins.datagen.provider.CoinsEnglishLanguageProvider;
import net.riser876.coins.datagen.provider.CoinsItemModelProvider;
import net.riser876.coins.datagen.provider.CoinsItemTagProvider;
import net.riser876.coins.util.CoinsGlobals;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = CoinsGlobals.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CoinsDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
                event.includeClient(),
                new CoinsItemModelProvider(output, existingFileHelper)
        );

        generator.addProvider(
                event.includeClient(),
                new CoinsEnglishLanguageProvider(output)
        );

        generator.addProvider(
                event.includeClient(),
                new CoinsBrazilianPortugueseLanguageProvider(output)
        );

        CoinsBlockTagProvider blockTags = new CoinsBlockTagProvider(
                output,
                lookupProvider,
                existingFileHelper
        );

        generator.addProvider(event.includeServer(), blockTags);

        generator.addProvider(
                event.includeServer(),
                new CoinsItemTagProvider(output, lookupProvider, blockTags.contentsGetter(), existingFileHelper)
        );
    }
}
