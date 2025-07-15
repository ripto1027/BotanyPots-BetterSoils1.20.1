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
import stan.ripto.bettersoils.item.CobblestoneGeneratorBlockItem;
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

    public static final RegistryObject<Block> COMPRESSED_COBBLESTONE = register(BlockData.SINGLE_STONE.NAME, BlockData.SINGLE_STONE.PROP);
    public static final RegistryObject<Block> DOUBLE_COMPRESSED_COBBLESTONE = register(BlockData.DOUBLE_STONE.NAME, BlockData.DOUBLE_STONE.PROP);
    public static final RegistryObject<Block> TRIPLE_COMPRESSED_COBBLESTONE = register(BlockData.TRIPLE_STONE.NAME, BlockData.TRIPLE_STONE.PROP);
    public static final RegistryObject<Block> QUADRUPLE_COMPRESSED_COBBLESTONE = register(BlockData.QUADRUPLE_STONE.NAME, BlockData.QUADRUPLE_STONE.PROP);
    public static final RegistryObject<Block> QUINTUPLE_COMPRESSED_COBBLESTONE = register(BlockData.QUINTUPLE_STONE.NAME, BlockData.QUINTUPLE_STONE.PROP);
    public static final RegistryObject<Block> SEXTUPLE_COMPRESSED_COBBLESTONE = register(BlockData.SEXTUPLE_STONE.NAME, BlockData.SEXTUPLE_STONE.PROP);
    public static final RegistryObject<Block> SEPTUPLE_COMPRESSED_COBBLESTONE = register(BlockData.SEPTUPLE_STONE.NAME, BlockData.SEPTUPLE_STONE.PROP);
    public static final RegistryObject<Block> OCTUPLE_COMPRESSED_COBBLESTONE = register(BlockData.OCTUPLE_STONE.NAME, BlockData.OCTUPLE_STONE.PROP);
    public static final RegistryObject<Block> NONTUPLE_COMPRESSED_COBBLESTONE = register(BlockData.NONTUPLE_STONE.NAME, BlockData.NONTUPLE_STONE.PROP);
    public static final RegistryObject<Block> DECUPLE_COMPRESSED_COBBLESTONE = register(BlockData.DECUPLE_STONE.NAME, BlockData.DECUPLE_STONE.PROP);
    public static final RegistryObject<Block> UNDECUPLE_COMPRESSED_COBBLESTONE = register(BlockData.UNDECUPLE_STONE.NAME, BlockData.UNDECUPLE_STONE.PROP);
    public static final RegistryObject<Block> DUODECUPLE_COMPRESSED_COBBLESTONE = register(BlockData.DUODECUPLE_STONE.NAME, BlockData.DUODECUPLE_STONE.PROP);

    public static final RegistryObject<Block> DIRT_GENERATOR = register(
            BlockData.DIRT_GENERATOR.NAME,
            DirtGeneratorBlock::new,
            DirtGeneratorBlockItem::new
    );

    public static final RegistryObject<Block> COBBLESTONE_GENERATOR = register(
            BlockData.COBBLESTONE_GENERATOR.NAME,
            CobblestoneGeneratorBlock::new,
            CobblestoneGeneratorBlockItem::new
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
            SEXTUPLE_COMPRESSED_DIRT,
            COMPRESSED_COBBLESTONE,
            DOUBLE_COMPRESSED_COBBLESTONE,
            TRIPLE_COMPRESSED_COBBLESTONE,
            QUADRUPLE_COMPRESSED_COBBLESTONE,
            QUINTUPLE_COMPRESSED_COBBLESTONE,
            SEXTUPLE_COMPRESSED_COBBLESTONE,
            SEPTUPLE_COMPRESSED_COBBLESTONE,
            OCTUPLE_COMPRESSED_COBBLESTONE,
            NONTUPLE_COMPRESSED_COBBLESTONE,
            DECUPLE_COMPRESSED_COBBLESTONE,
            UNDECUPLE_COMPRESSED_COBBLESTONE,
            DUODECUPLE_COMPRESSED_COBBLESTONE
    );

    public static final List<RegistryObject<Block>> dirtRegistryList = List.of(
            COMPRESSED_DIRT,
            DOUBLE_COMPRESSED_DIRT,
            TRIPLE_COMPRESSED_DIRT,
            QUADRUPLE_COMPRESSED_DIRT,
            QUINTUPLE_COMPRESSED_DIRT,
            SEXTUPLE_COMPRESSED_DIRT
    );

    public static final List<RegistryObject<Block>> cobblestoneRegistryList = List.of(
            COMPRESSED_COBBLESTONE,
            DOUBLE_COMPRESSED_COBBLESTONE,
            TRIPLE_COMPRESSED_COBBLESTONE,
            QUADRUPLE_COMPRESSED_COBBLESTONE,
            QUINTUPLE_COMPRESSED_COBBLESTONE,
            SEXTUPLE_COMPRESSED_COBBLESTONE,
            SEPTUPLE_COMPRESSED_COBBLESTONE,
            OCTUPLE_COMPRESSED_COBBLESTONE,
            NONTUPLE_COMPRESSED_COBBLESTONE,
            DECUPLE_COMPRESSED_COBBLESTONE,
            UNDECUPLE_COMPRESSED_COBBLESTONE,
            DUODECUPLE_COMPRESSED_COBBLESTONE
    );
}
