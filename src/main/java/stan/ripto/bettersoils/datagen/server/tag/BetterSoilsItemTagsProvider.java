package stan.ripto.bettersoils.datagen.server.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stan.ripto.bettersoils.BetterSoils;

import java.util.concurrent.CompletableFuture;

public class BetterSoilsItemTagsProvider extends ItemTagsProvider {
    public BetterSoilsItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, BetterSoils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider pProvider) {
        copy(BlockTags.DIRT, ItemTags.DIRT);
        copy(Tags.Blocks.COBBLESTONE, Tags.Items.COBBLESTONE);
        copy(BetterSoilsTags.Blocks.STORAGE_BLOCKS_DIRT, BetterSoilsTags.Items.STORAGE_BLOCKS_DIRT);
        copy(BetterSoilsTags.Blocks.STORAGE_BLOCKS_COBBLESTONE, BetterSoilsTags.Items.STORAGE_BLOCKS_COBBLESTONE);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
    }
}
