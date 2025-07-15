package stan.ripto.bettersoils.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stan.ripto.bettersoils.blockentity.GeneratorBlockEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class GeneratorBlock<G extends GeneratorBlockEntity> extends BaseEntityBlock {
    private final RegistryObject<BlockEntityType<G>> registry;
    private final BiFunction<BlockPos, BlockState, G> factory;
    private final Class<G> tileClass;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public GeneratorBlock(Properties prop, RegistryObject<BlockEntityType<G>> registry, BiFunction<BlockPos, BlockState, G> factory, Class<G> tileClass) {
        super(prop);
        this.registry = registry;
        this.factory = factory;
        this.tileClass = tileClass;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.FALSE));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return factory.apply(pPos, pState);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity tile = pLevel.getBlockEntity(pPos);
            if (tileClass.isInstance(tile)) {
                tileClass.cast(tile).dropItems();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide()) return null;
        return createTickerHelper(pBlockEntityType, registry.get(), (level, pos, state, tile) -> tile.tick(level));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        if (stack.getItem() == Items.DIAMOND) {
            int count = stack.getCount();
            BlockEntity tile = pLevel.getBlockEntity(pPos);
            if (tileClass.isInstance(tile)) {
                int result = tileClass.cast(tile).addGenerateCount(count);
                stack.shrink(64 - result);
                return InteractionResult.SUCCESS;
            } else {
                return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
            }
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState pState,@NotNull LootParams.Builder pParams) {
        List<ItemStack> drops = new ArrayList<>();
        ItemStack stack = new ItemStack(this);
        BlockEntity tile = pParams.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (tileClass.isInstance(tile)) {
            CompoundTag nbt = stack.getOrCreateTag();
            G genTile = tileClass.cast(tile);
            genTile.saveAdditional(nbt);
            genTile.setChanged();
        }
        drops.add(stack);
        return drops;
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LIT);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
        return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
}
