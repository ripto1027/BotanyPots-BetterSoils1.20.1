package stan.ripto.bettersoils.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;

public class CobblestoneGeneratorBlockEntity extends GeneratorBlockEntity {
    public CobblestoneGeneratorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BetterSoilsBlockEntities.COBBLESTONE_GENERATOR.get(), pPos, pBlockState, Items.COBBLESTONE);
    }
}
