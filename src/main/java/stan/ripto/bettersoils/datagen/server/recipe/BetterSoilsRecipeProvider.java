package stan.ripto.bettersoils.datagen.server.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;
import stan.ripto.bettersoils.datagen.server.recipe.builder.SoilsRecipeBuilder;

import java.util.List;
import java.util.function.Consumer;

public class BetterSoilsRecipeProvider extends RecipeProvider {
    public BetterSoilsRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> writer) {
        shaped(writer, Blocks.DIRT, BetterSoilsBlocks.COMPRESSED_DIRT.get());
        shaped(writer, BetterSoilsBlocks.COMPRESSED_DIRT.get(), BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT.get());
        shaped(writer, BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT.get());
        shaped(writer, BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT.get());
        shaped(writer, BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT.get());
        shaped(writer, BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT.get());

        generatorRecipes(writer, BetterSoilsBlocks.DIRT_GENERATOR.get(), BetterSoilsBlocks.COMPRESSED_DIRT.get());

        List<String> categories = List.of("dirt", "stone", "water", "sand", "wood", "soul_sand", "crimson_nylium", "warped_nylium");

        soilRecipes(writer, BetterSoilsBlocks.COMPRESSED_DIRT.get(), categories, 1.2F);
        soilRecipes(writer, BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT.get(), categories, 1.5F);
        soilRecipes(writer, BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT.get(), categories, 2.0F);
        soilRecipes(writer, BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT.get(), categories, 3.0F);
        soilRecipes(writer, BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT.get(), categories, 6.0F);
        soilRecipes(writer, BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT.get(), categories, 12.0F);
    }

    private void shaped(Consumer<FinishedRecipe> writer, ItemLike ingredient, ItemLike result) {
        ResourceLocation rl = ForgeRegistries.ITEMS.getKey(result.asItem());
        if (rl == null) return;

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                .define('A', ingredient)
                .define('B', Items.BONE_BLOCK)
                .define('C', Items.BROWN_DYE)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .group(rl.getPath())
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(writer, rl.getPath());
    }

    private void generatorRecipes(Consumer<FinishedRecipe> writer, ItemLike generator, ItemLike material) {
        ResourceLocation generatorLocation = ForgeRegistries.ITEMS.getKey(generator.asItem());
        if (generatorLocation == null) return;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, generator)
                .define('A', Items.IRON_INGOT)
                .define('B', Items.SMOOTH_STONE)
                .define('C', material)
                .pattern("AAA")
                .pattern("ACA")
                .pattern("BBB")
                .group("generator")
                .unlockedBy(getHasName(material), has(material))
                .save(writer, generatorLocation.getPath());
    }

    private void soilRecipes(Consumer<FinishedRecipe> writer, Block input, List<String> categories, float growthModifier) {
        ResourceLocation inputKey = ForgeRegistries.BLOCKS.getKey(input);

        if (inputKey == null) return;
        String name = inputKey.getPath();

        writer.accept(
                SoilsRecipeBuilder.create(
                        ResourceLocation.fromNamespaceAndPath(BetterSoils.MOD_ID, name),
                        input,
                        categories,
                        growthModifier
                )
        );
    }
}
