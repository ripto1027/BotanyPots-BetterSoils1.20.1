package stan.ripto.bettersoils.datagen.server.recipe.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.darkhax.botanypots.BotanyPotHelper;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CropRecipeBuilder implements FinishedRecipe {
    private final ResourceLocation id;

    private final String input;
    private final String display;
    private final List<String> categories;
    private final float growthTicks;
    private final String drop;

    public CropRecipeBuilder(ResourceLocation id, String input, String display, List<String> categories, float growthTicks, String drop) {
        this.id = id;
        this.input = input;
        this.display = display;
        this.categories = categories;
        this.growthTicks = growthTicks;
        this.drop = drop;
    }

    public static CropRecipeBuilder create(ResourceLocation id, String input, String display, List<String> categories, float growthTicks, String drop) {
        return new CropRecipeBuilder(id, input, display, categories, growthTicks, drop);
    }

    @Override
    public void serializeRecipeData(@NotNull JsonObject pJson) {
        JsonArray conditionArr = new JsonArray();
        JsonObject conditionObj = new JsonObject();
        conditionObj.addProperty("type", "bookshelf:item_exists");
        conditionObj.addProperty("values", input);
        conditionArr.add(conditionObj);
        pJson.add("bookshelf:load_conditions", conditionArr);

        pJson.addProperty("type", "botanypots:crop");

        JsonObject seedObj = new JsonObject();
        seedObj.addProperty("item", input);
        pJson.add("seed", seedObj);

        JsonArray categoriesArr = new JsonArray();
        categories.forEach(categoriesArr::add);
        pJson.add("categories", categoriesArr);

        pJson.addProperty("growthTicks", growthTicks);

        JsonObject displayObj = new JsonObject();
        displayObj.addProperty("block", display);
        pJson.add("display", displayObj);

        JsonArray dropArr = new JsonArray();
        JsonObject dropObj = new JsonObject();
        JsonObject outputObj = new JsonObject();
        outputObj.addProperty("item", drop);
        dropObj.addProperty("chance", 1.00F);
        dropObj.add("output", outputObj);
        dropArr.add(dropObj);
        pJson.add("drops", dropArr);
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getType() {
        return BotanyPotHelper.CROP_SERIALIZER.get();
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
