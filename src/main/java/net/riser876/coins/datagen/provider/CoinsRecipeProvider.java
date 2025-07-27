package net.riser876.coins.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.riser876.coins.item.CoinsId;
import net.riser876.coins.item.CoinsItem;
import net.riser876.coins.registry.CoinsTag;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CoinsRecipeProvider extends FabricRecipeProvider {

    public CoinsRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerCoinFromIngot(recipeExporter, CoinsItem.GOLD_COIN, ConventionalItemTags.GOLD_INGOTS, CoinsId.GOLD_COIN.getId());
        offerCoinFromIngot(recipeExporter, CoinsItem.IRON_COIN, ConventionalItemTags.IRON_INGOTS, CoinsId.IRON_COIN .getId());
        offerCoinFromIngot(recipeExporter, CoinsItem.COPPER_COIN, ConventionalItemTags.COPPER_INGOTS, CoinsId.COPPER_COIN.getId());

        offerCoinCompressed(recipeExporter, CoinsItem.GOLD_COIN, CoinsTag.IRON_COIN, CoinsId.GOLD_COIN.getId());
        offerCoinCompressed(recipeExporter, CoinsItem.IRON_COIN, CoinsTag.COPPER_COIN, CoinsId.IRON_COIN.getId());

        offerCoinDecompressed(recipeExporter, CoinsItem.IRON_COIN, CoinsTag.GOLD_COIN, CoinsId.IRON_COIN.getId(), 9);
        offerCoinDecompressed(recipeExporter, CoinsItem.COPPER_COIN, CoinsTag.IRON_COIN, CoinsId.COPPER_COIN.getId(), 9);
    }

    private static void offerCoinFromIngot(RecipeExporter recipeExporter, ItemConvertible item, TagKey<Item> tag, String group) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, item, 4)
                .pattern("ii")
                .pattern("ii")
                .input('i', tag)
                .group(group)
                .criterion("has_ingot", conditionsFromTag(tag))
                .criterion("has_coin", conditionsFromTag(CoinsTag.COINS))
                .offerTo(recipeExporter);
    }

    private static void offerCoinCompressed(RecipeExporter exporter, ItemConvertible output, TagKey<Item> input, @Nullable String group) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input(Ingredient.fromTag(input), 9)
                .group(group)
                .criterion("has_coin", conditionsFromTag(CoinsTag.COINS))
                .offerTo(exporter, convertBetween(output, input));
    }

    public static void offerCoinDecompressed(RecipeExporter exporter, ItemConvertible output, TagKey<Item> input, @Nullable String group, int outputCount) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, outputCount)
                .input(Ingredient.fromTag(input), 1)
                .group(group)
                .criterion("has_coin", conditionsFromTag(CoinsTag.COINS))
                .offerTo(exporter, convertBetween(output, input));
    }

    private static String convertBetween(ItemConvertible output, TagKey<Item> input) {
        return Registries.ITEM.getId(output.asItem()).getPath() + "_from_" + input.id().getPath();
    }
}