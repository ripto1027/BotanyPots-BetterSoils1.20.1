package stan.ripto.bettersoils.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.item.BetterSoilsItems;
import stan.ripto.bettersoils.item.DirtGeneratorBlockItem;

import java.util.List;
import java.util.function.Supplier;

public class BetterSoilsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterSoils.MOD_ID);

    public static final RegistryObject<Block> COMPRESSED_DIRT = register(BlockData.SINGLE_DIRT.NAME, BlockData.SINGLE_DIRT.PROP);
    public static final RegistryObject<Block> DOUBLE_COMPRESSED_DIRT = register(BlockData.DOUBLE_DIRT.NAME, BlockData.DOUBLE_DIRT.PROP);
    public static final RegistryObject<Block> TRIPLE_COMPRESSED_DIRT = register(BlockData.TRIPLE_DIRT.NAME, BlockData.TRIPLE_DIRT.PROP);
    public static final RegistryObject<Block> QUADRUPLE_COMPRESSED_DIRT = register(BlockData.QUADRUPLE_DIRT.NAME, BlockData.QUADRUPLE_DIRT.PROP);
    public static final RegistryObject<Block> QUINTUPLE_COMPRESSED_DIRT = register(BlockData.QUINTUPLE_DIRT.NAME, BlockData.QUINTUPLE_DIRT.PROP);
    public static final RegistryObject<Block> SEXTUPLE_COMPRESSED_DIRT = register(BlockData.SEXTUPLE_DIRT.NAME, BlockData.SEXTUPLE_DIRT.PROP);

    public static final RegistryObject<Block> DIRT_GENERATOR = register(
            BlockData.DIRT_GENERATOR.NAME,
            DirtGeneratorBlock::new,
            DirtGeneratorBlockItem::new
    );

    private static RegistryObject<Block> register(String name, BlockBehaviour.Properties prop) {
        RegistryObject<Block> registry = BLOCKS.register(name, () -> new Block(prop));
        BetterSoilsItems.ITEMS.register(name, () -> new BlockItem(registry.get(), new Item.Properties()));
        return registry;
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        RegistryObject<Block> registry = BLOCKS.register(name, blockSupplier);
        BetterSoilsItems.ITEMS.register(name, itemSupplier);
        return registry;
    }

    public static final List<RegistryObject<Block>> blockRegistryList = List.of(
            COMPRESSED_DIRT,
            DOUBLE_COMPRESSED_DIRT,
            TRIPLE_COMPRESSED_DIRT,
            QUADRUPLE_COMPRESSED_DIRT,
            QUINTUPLE_COMPRESSED_DIRT,
            SEXTUPLE_COMPRESSED_DIRT
    );
}
