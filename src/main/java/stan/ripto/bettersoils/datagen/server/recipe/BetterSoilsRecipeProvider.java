package stan.ripto.bettersoils.datagen.server.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;
import stan.ripto.bettersoils.datagen.server.recipe.builder.CropRecipeBuilder;
import stan.ripto.bettersoils.datagen.server.recipe.builder.SoilsRecipeBuilder;

import java.util.List;
import java.util.function.Consumer;

public class BetterSoilsRecipeProvider extends RecipeProvider {
    public BetterSoilsRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> writer) {
        nineBlockStorageRecipes(writer, Blocks.DIRT, BetterSoilsBlocks.COMPRESSED_DIRT.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.COMPRESSED_DIRT.get(), BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT.get(), BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT.get());

        nineBlockStorageRecipes(writer, Blocks.COBBLESTONE, BetterSoilsBlocks.COMPRESSED_COBBLESTONE.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.TRIPLE_COMPRESSED_COBBLESTONE.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.TRIPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE.get());
        nineBlockStorageRecipes(writer, BetterSoilsBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE.get());
        fourBlockStorageRecipes(writer, BetterSoilsBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.SEPTUPLE_COMPRESSED_COBBLESTONE.get());
        fourBlockStorageRecipes(writer, BetterSoilsBlocks.SEPTUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.OCTUPLE_COMPRESSED_COBBLESTONE.get());
        fourBlockStorageRecipes(writer, BetterSoilsBlocks.OCTUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.NONTUPLE_COMPRESSED_COBBLESTONE.get());
        fourBlockStorageRecipes(writer, BetterSoilsBlocks.NONTUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.DECUPLE_COMPRESSED_COBBLESTONE.get());
        fourBlockStorageRecipes(writer, BetterSoilsBlocks.DECUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.UNDECUPLE_COMPRESSED_COBBLESTONE.get());
        fourBlockStorageRecipes(writer, BetterSoilsBlocks.UNDECUPLE_COMPRESSED_COBBLESTONE.get(), BetterSoilsBlocks.DUODECUPLE_COMPRESSED_COBBLESTONE.get());

        generatorRecipes(writer, BetterSoilsBlocks.DIRT_GENERATOR.get(), BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT.get());
        generatorRecipes(writer, BetterSoilsBlocks.COBBLESTONE_GENERATOR.get(), BetterSoilsBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get());

        soilRecipes(writer, BetterSoilsBlocks.COMPRESSED_DIRT.get(), List.of("dirt"), 1.2F);
        soilRecipes(writer, BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT.get(), List.of("dirt"), 1.5F);
        soilRecipes(writer, BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT.get(), List.of("dirt"), 2.0F);
        soilRecipes(writer, BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT.get(), List.of("dirt"), 3.0F);
        soilRecipes(writer, BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT.get(), List.of("dirt"), 6.0F);
        soilRecipes(writer, BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT.get(), List.of("dirt"), 12.0F);

        soilRecipes(writer, BetterSoilsBlocks.COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 1.0F);
        soilRecipes(writer, BetterSoilsBlocks.DOUBLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 1.09F);
        soilRecipes(writer, BetterSoilsBlocks.TRIPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 1.2F);
        soilRecipes(writer, BetterSoilsBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 1.33F);
        soilRecipes(writer, BetterSoilsBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 1.5F);
        soilRecipes(writer, BetterSoilsBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 1.71F);
        soilRecipes(writer, BetterSoilsBlocks.SEPTUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 2.0F);
        soilRecipes(writer, BetterSoilsBlocks.OCTUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 2.4F);
        soilRecipes(writer, BetterSoilsBlocks.NONTUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 3.0F);
        soilRecipes(writer, BetterSoilsBlocks.DECUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 4.0F);
        soilRecipes(writer, BetterSoilsBlocks.UNDECUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 6.0F);
        soilRecipes(writer, BetterSoilsBlocks.DUODECUPLE_COMPRESSED_COBBLESTONE.get(), List.of("compressed_cobblestone"), 12.0F);

        cropRecipesDrops(writer, "minecraft:amethyst_block", "minecraft:amethyst_shard");
        cropRecipesDrops(writer, "minecraft:clay", "minecraft:clay_ball");
        cropRecipesDrops(writer, "minecraft:coal_block", "minecraft:coal");
        cropRecipesDrops(writer, "minecraft:copper_block", "minecraft:copper_ingot");
        cropRecipesDrops(writer, "minecraft:diamond_block", "minecraft:diamond");
        cropRecipesDrops(writer, "minecraft:emerald_block", "minecraft:emerald");
        cropRecipesDrops(writer, "minecraft:glowstone", "minecraft:glowstone_dust");
        cropRecipesDrops(writer, "minecraft:gold_block", "minecraft:gold_ingot");
        cropRecipesDrops(writer, "minecraft:iron_block", "minecraft:iron_ingot");
        cropRecipesDrops(writer, "minecraft:lapis_block", "minecraft:lapis_lazuli");
        cropRecipesDisplay(writer, "minecraft:netherite_ingot", "minecraft:netherite_block");
        cropRecipes(writer, "minecraft:obsidian");
        cropRecipesDrops(writer, "minecraft:quartz_block", "minecraft:quartz");
        cropRecipesDrops(writer, "minecraft:redstone_block", "minecraft:redstone");

        cropRecipesDisplay(writer, "ae2:certus_quartz_crystal", "ae2:quartz_cluster");
        cropRecipesDisplay(writer, "ae2:certus_quartz_dust", "ae2:certus_quartz_bud");
        cropRecipesDisplay(writer, "ae2:fluix_crystal", "ae2:fluix_block");
        cropRecipes(writer, "ae2:sky_stone_block");

        cropRecipesDrops(writer, "create:zinc_block", "create:zinc_ingot");

        cropRecipesDrops(writer, "immersiveengineering:storage_aluminum", "immersiveengineering:ingot_aluminum");
        cropRecipesDrops(writer, "immersiveengineering:storage_nickel", "immersiveengineering:ingot_nickel");
        cropRecipesDrops(writer, "immersiveengineering:storage_silver", "immersiveengineering:ingot_silver");
        cropRecipesDrops(writer, "immersiveengineering:storage_lead", "immersiveengineering:ingot_lead");
        cropRecipesDrops(writer, "immersiveengineering:storage_uranium", "immersiveengineering:ingot_uranium");

        cropRecipesDrops(writer, "megacells:sky_steel_block", "megacells:sky_steel_ingot");

        cropRecipesDrops(writer, "mekanism:block_fluorite", "mekanism:fluorite_gem");
        cropRecipesDrops(writer, "mekanism:block_lead", "mekanism:ingot_lead");
        cropRecipesDrops(writer, "mekanism:block_osmium", "mekanism:ingot_osmium");
        cropRecipesDrops(writer, "mekanism:block_tin", "mekanism:ingot_tin");
        cropRecipesDrops(writer, "mekanism:block_uranium", "mekanism:ingot_uranium");

        cropRecipesDrops(writer, "powah:uraninite_block", "powah:uraninite");

        cropRecipesDrops(writer, "tconstruct:cobalt_block", "tconstruct:cobalt_ingot");
        cropRecipesDrops(writer, "tconstruct:earth_slime_crystal_block", "tconstruct:earth_slime_crystal");
        cropRecipesDrops(writer, "tconstruct:ender_slime_crystal_block", "tconstruct:ender_slime_crystal");
        cropRecipesDrops(writer, "tconstruct:ichor_slime_crystal_block", "tconstruct:ichor_slime_crystal");
        cropRecipesDrops(writer, "tconstruct:sky_slime_crystal_block", "tconstruct:sky_slime_crystal");
    }

    private void nineBlockStorageRecipes(Consumer<FinishedRecipe> writer, Block decompressed, Block compressed) {
        Item decompressedItem = decompressed.asItem();
        Item compressedItem = compressed.asItem();

        ResourceLocation decompressedLocation = ForgeRegistries.BLOCKS.getKey(decompressed);
        ResourceLocation compressedLocation = ForgeRegistries.BLOCKS.getKey(compressed);
        if (compressedLocation == null || decompressedLocation == null) return;

        String decompressedName = decompressedLocation.getPath();
        String compressedName = compressedLocation.getPath();

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, decompressedItem, 9)
                .requires(compressedItem)
                .group("decompress")
                .unlockedBy(getHasName(compressedItem), has(compressedItem))
                .save(writer, "decompress_" + decompressedName);

        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, compressedItem)
                .define('#', decompressedItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group("compress")
                .unlockedBy(getHasName(decompressedItem), has(decompressedItem))
                .save(writer, "compress_" + compressedName);
    }

    private void fourBlockStorageRecipes(Consumer<FinishedRecipe> writer, Block decompressed, Block compressed) {
        Item decompressedItem = decompressed.asItem();
        Item compressedItem = compressed.asItem();

        ResourceLocation decompressedLocation = ForgeRegistries.BLOCKS.getKey(decompressed);
        ResourceLocation compressedLocation = ForgeRegistries.BLOCKS.getKey(compressed);
        if (compressedLocation == null || decompressedLocation == null) return;

        String decompressedName = decompressedLocation.getPath();
        String compressedName = compressedLocation.getPath();

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, decompressedItem, 4)
                .requires(compressedItem)
                .group("decompress")
                .unlockedBy(getHasName(compressedItem), has(compressedItem))
                .save(writer, "decompress_" + decompressedName);

        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, compressedItem)
                .define('#', decompressedItem)
                .pattern("##")
                .pattern("##")
                .group("compress")
                .unlockedBy(getHasName(decompressedItem), has(decompressedItem))
                .save(writer, "compress_" + compressedName);
    }

    private void generatorRecipes(Consumer<FinishedRecipe> writer, Block generator, Block materialBlock) {
        Item generatorItem = generator.asItem();
        Item material = materialBlock.asItem();

        ResourceLocation generatorLocation = ForgeRegistries.BLOCKS.getKey(generator);

        if (generatorLocation == null) return;
        String generatorName = generatorLocation.getPath();

        ShapedRecipeBuilder
                .shaped(RecipeCategory.MISC, generatorItem)
                .define('A', Items.DIAMOND)
                .define('B', material)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .group("generator")
                .unlockedBy(getHasName(material), has(material))
                .save(writer, generatorName);
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

    @SuppressWarnings("SameParameterValue")
    private void cropRecipes(Consumer<FinishedRecipe> writer, String input, String display, List<String> categories, float growthTicks, String drop) {
        String name = input.split(":")[1];
        writer.accept(
                CropRecipeBuilder.create(
                        ResourceLocation.fromNamespaceAndPath(BetterSoils.MOD_ID, name),
                        input,
                        display,
                        categories,
                        growthTicks,
                        drop
                )
        );
    }

    private void cropRecipesDrops(Consumer<FinishedRecipe> writer, String input, String drop) {
        cropRecipes(writer, input, input, List.of("compressed_cobblestone"), 1200F, drop);
    }

    private void cropRecipes(Consumer<FinishedRecipe> writer, String input) {
        cropRecipes(writer, input, input, List.of("compressed_cobblestone"), 1200F, input);
    }

    private void cropRecipesDisplay(Consumer<FinishedRecipe> writer, String input, String display) {
        cropRecipes(writer, input, display, List.of("compressed_cobblestone"), 1200F, input);
    }
}
