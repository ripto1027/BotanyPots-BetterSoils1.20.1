package stan.ripto.bettersoils.datagen.server.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;

import java.util.concurrent.CompletableFuture;

public class BetterSoilsBlockTagsProvider extends BlockTagsProvider {
    public BetterSoilsBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BetterSoils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider pProvider) {
        BetterSoilsBlocks.blockRegistryList.forEach(element -> {
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(element.get());
            tag(BlockTags.DIRT).add(element.get());
        });

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BetterSoilsBlocks.DIRT_GENERATOR.get());
    }
}
