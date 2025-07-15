package stan.ripto.bettersoils.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.datagen.client.blockstate.BetterSoilsBlockStateProvider;
import stan.ripto.bettersoils.datagen.client.lang.BetterSoilsLanguageProvider;
import stan.ripto.bettersoils.datagen.server.loot.BetterSoilsLootTableProvider;
import stan.ripto.bettersoils.datagen.server.recipe.BetterSoilsRecipeProvider;
import stan.ripto.bettersoils.datagen.server.tag.BetterSoilsBlockTagsProvider;
import stan.ripto.bettersoils.datagen.server.tag.BetterSoilsItemTagsProvider;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = BetterSoils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterSoilsDataGenerator {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeClient(), new BetterSoilsBlockStateProvider(output, efh));
        gen.addProvider(event.includeClient(), new BetterSoilsLanguageProvider.ENUS(output));
        gen.addProvider(event.includeClient(), new BetterSoilsLanguageProvider.JAJP(output));

        gen.addProvider(event.includeServer(), BetterSoilsLootTableProvider.create(output));
        gen.addProvider(event.includeServer(), new BetterSoilsRecipeProvider(output));
        BetterSoilsBlockTagsProvider blockTagsProvider = gen.addProvider(event.includeServer(), new BetterSoilsBlockTagsProvider(output, lookupProvider, efh));
        gen.addProvider(event.includeServer(), new BetterSoilsItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), efh));
    }
}
