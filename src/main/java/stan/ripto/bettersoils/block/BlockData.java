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
    DIRT_GENERATOR("dirt_generator", BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE));

    public final String NAME;
    public final BlockBehaviour.Properties PROP;

    BlockData(String name, BlockBehaviour.Properties properties) {
        this.NAME = name;
        this.PROP = properties;
    }
}
