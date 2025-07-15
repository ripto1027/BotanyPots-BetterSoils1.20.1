package stan.ripto.bettersoils.datagen.server.recipe.builder;

import com.google.gson.*;
import net.darkhax.botanypots.BotanyPotHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoilsRecipeBuilder implements FinishedRecipe {
    private final ResourceLocation id;

    private final String input;
    private final List<String> categories;
    private final float growthModifier;

    public SoilsRecipeBuilder(ResourceLocation id,Block input, List<String> categories, float growthModifier) {
        this.id = id;
        this.input = getKeyString(input);
        this.categories = categories;
        this.growthModifier = growthModifier;
    }

    public static SoilsRecipeBuilder create(ResourceLocation id, Block input, List<String> categories, float growthModifier) {
        return new SoilsRecipeBuilder(id, input, categories, growthModifier);
    }


    private static String getKeyString(Block block) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        if (key != null) {
            return key.toString();
        } else {
            return null;
        }
    }

    @Override
    public void serializeRecipeData(@NotNull JsonObject json) {
        json.addProperty("type", "botanypots:soil");

        JsonObject objInput = new JsonObject();
        objInput.addProperty("item", input);
        json.add("input", objInput);

        JsonObject objDisplay = new JsonObject();
        objDisplay.addProperty("block", input);
        json.add("display", objDisplay);

        JsonArray arrCategories = new JsonArray();
        categories.forEach(arrCategories::add);
        json.add("categories", arrCategories);

        json.addProperty("growthModifier", growthModifier);
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getType() {
        return BotanyPotHelper.SOIL_SERIALIZER.get();
    }

    @Override
    public @Nullable JsonObject serializeAdvancement() {
        return null;
    }

    @Override
    public @Nullable ResourceLocation getAdvancementId() {
        return null;
    }
}
