package stan.ripto.bettersoils.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;

public class DirtGeneratorBlockEntity extends GeneratorBlockEntity {
    public DirtGeneratorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BetterSoilsBlockEntities.DIRT_GENERATOR.get(), pPos, pBlockState, Items.DIRT);
    }
}
