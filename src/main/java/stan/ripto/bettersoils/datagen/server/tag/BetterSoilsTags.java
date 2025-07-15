package stan.ripto.bettersoils.datagen.server.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BetterSoilsTags {
    public static final String FORGE = "forge";

    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS_DIRT = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FORGE, "storage_blocks/dirt"));
        public static final TagKey<Block> STORAGE_BLOCKS_COBBLESTONE = BlockTags.create(ResourceLocation.fromNamespaceAndPath(FORGE, "storage_blocks/cobblestone"));
    }

    public static class Items {
        public static final TagKey<Item> STORAGE_BLOCKS_DIRT = ItemTags.create(ResourceLocation.fromNamespaceAndPath(FORGE, "storage_blocks/dirt"));
        public static final TagKey<Item> STORAGE_BLOCKS_COBBLESTONE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(FORGE, "storage_blocks/cobblestone"));
    }
}
