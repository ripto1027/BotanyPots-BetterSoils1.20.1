package stan.ripto.bettersoils.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public enum BlockData {
    SINGLE_DIRT("compressed_dirt", BlockBehaviour.Properties.copy(Blocks.DIRT).strength(1.0F)),
    DOUBLE_DIRT("double_compressed_dirt", BlockBehaviour.Properties.copy(Blocks.DIRT).strength(1.5F)),
    TRIPLE_DIRT("triple_compressed_dirt", BlockBehaviour.Properties.copy(Blocks.DIRT).strength(2.0F)),
    QUADRUPLE_DIRT("quadruple_compressed_dirt", BlockBehaviour.Properties.copy(Blocks.DIRT).strength(2.5F)),
    QUINTUPLE_DIRT("quintuple_compressed_dirt", BlockBehaviour.Properties.copy(Blocks.DIRT).strength(3.0F)),
    SEXTUPLE_DIRT("sextuple_compressed_dirt", BlockBehaviour.Properties.copy(Blocks.DIRT).strength(3.5F)),
    DIRT_GENERATOR("dirt_generator", BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)),
    SINGLE_STONE("compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(5.0F, 100.0F)),
    DOUBLE_STONE("double_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(10.0F, 200.0F)),
    TRIPLE_STONE("triple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(15.0F, 300.0F)),
    QUADRUPLE_STONE("quadruple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(20.0F, 400.0F)),
    QUINTUPLE_STONE("quintuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(25.0F, 500.0F)),
    SEXTUPLE_STONE("sextuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(30.0F, 600.0F)),
    SEPTUPLE_STONE("septuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(35.0F, 700.0F)),
    OCTUPLE_STONE("octuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(40.0F, 800.0F)),
    NONTUPLE_STONE("nontuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(45.0F, 900.0F)),
    DECUPLE_STONE("decuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(50.0F, 1000.0F)),
    UNDECUPLE_STONE("undecuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(55.0F, 1100.0F)),
    DUODECUPLE_STONE("duodecuple_compressed_cobblestone", BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(60.0F, 1200.0F)),
    COBBLESTONE_GENERATOR("cobblestone_generator", BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE));

    public final String NAME;
    public final BlockBehaviour.Properties PROP;

    BlockData(String name, BlockBehaviour.Properties properties) {
        this.NAME = name;
        this.PROP = properties;
    }
}
