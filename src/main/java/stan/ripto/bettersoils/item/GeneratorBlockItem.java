package stan.ripto.bettersoils.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stan.ripto.bettersoils.blockentity.GeneratorBlockEntity;
import stan.ripto.bettersoils.datagen.client.lang.TranslateKeys;

import java.util.List;

public class GeneratorBlockItem<G extends GeneratorBlockEntity> extends BlockItem {
    private final Class<G> tileClass;
    protected int currentGenerateCount = 1;

    public GeneratorBlockItem(Block pBlock, Class<G> tileClass) {
        super(pBlock, new Item.Properties());
        this.tileClass = tileClass;
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockEntity tile = level.getBlockEntity(pos);

        if (tile != null && player != null && player.isShiftKeyDown() && tile.getCapability(ForgeCapabilities.ITEM_HANDLER).isPresent()) {
            CompoundTag nbt = pContext.getItemInHand().getOrCreateTag();
            nbt.putLong(GeneratorBlockEntity.SAVE_TARGET_POS, pos.asLong());
            if (level.isClientSide()) {
                String tileName = tile.getBlockState().getBlock().getName().getString();
                player.displayClientMessage(Component.translatable(TranslateKeys.linkedMessage.KEY, tileName, pos.getX(), pos.getY(), pos.getZ()), true);
            }
            return InteractionResult.SUCCESS;
        } else {
            return super.useOn(pContext);
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        CompoundTag nbt = stack.getTag();
        if (pPlayer.isShiftKeyDown() && nbt != null && nbt.contains(GeneratorBlockEntity.SAVE_TARGET_POS)) {
            nbt.remove(GeneratorBlockEntity.SAVE_TARGET_POS);
            if (pLevel.isClientSide()) {
                pPlayer.displayClientMessage(Component.translatable(TranslateKeys.unlinkedMessage.KEY), true);
            }
            return InteractionResultHolder.success(stack);
        } else {
            return InteractionResultHolder.fail(stack);
        }
    }

    @Override
    public boolean placeBlock(@NotNull BlockPlaceContext pContext, @NotNull BlockState pState) {
        boolean placed = super.placeBlock(pContext, pState);
        CompoundTag nbt = pContext.getItemInHand().getTag();
        if (placed && nbt != null && nbt.contains(GeneratorBlockEntity.SAVE_TARGET_POS)) {
            BlockPos pos = pContext.getClickedPos();
            BlockEntity currentTile = pContext.getLevel().getBlockEntity(pos);
            if (tileClass.isInstance(currentTile)) {
                BlockPos target = BlockPos.of(nbt.getLong(GeneratorBlockEntity.SAVE_TARGET_POS));
                tileClass.cast(currentTile).setTargetPos(target);
            }
        }
        return placed;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltip, @NotNull TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        CompoundTag nbt = pStack.getTag();
        if (nbt != null) {
            if (nbt.contains(GeneratorBlockEntity.SAVE_TARGET_POS)) {
                BlockPos pos = BlockPos.of(nbt.getLong(GeneratorBlockEntity.SAVE_TARGET_POS));
                String name = "Unknown";
                if (pLevel != null && pLevel.isClientSide()) {
                    BlockState state = pLevel.getBlockState(pos);
                    name = state.getBlock().getName().getString();
                }
                pTooltip.add(Component.translatable(TranslateKeys.linkedPosTooltip.KEY, name, pos.getX(), pos.getY(), pos.getZ()).withStyle(ChatFormatting.GRAY));
            }
            if (nbt.contains(GeneratorBlockEntity.SAVE_GENERATE_COUNT)) {
                currentGenerateCount = nbt.getInt(GeneratorBlockEntity.SAVE_GENERATE_COUNT);
                pTooltip.add(Component.translatable(TranslateKeys.generateCountTooltip.KEY, currentGenerateCount).withStyle(ChatFormatting.GRAY));
            } else {
                pTooltip.add(Component.translatable(TranslateKeys.generateCountTooltip.KEY, 1).withStyle(ChatFormatting.GRAY));
            }
        } else {
            pTooltip.add(Component.translatable(TranslateKeys.generateCountTooltip.KEY, 1).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public boolean updateCustomBlockEntityTag(@NotNull BlockPos pPos, @NotNull Level pLevel, @Nullable Player pPlayer, @NotNull ItemStack pStack, @NotNull BlockState pState) {
        BlockEntity tile = pLevel.getBlockEntity(pPos);
        if (tileClass.isInstance(tile)) {
            CompoundTag nbt = pStack.getOrCreateTag();
            G genTile = tileClass.cast(tile);
            genTile.load(nbt);
            genTile.setChanged();
        }
        return super.updateCustomBlockEntityTag(pPos, pLevel, pPlayer, pStack, pState);
    }
}
