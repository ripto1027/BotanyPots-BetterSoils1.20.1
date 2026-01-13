package stan.ripto.bettersoils.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GeneratorBlockEntity extends BlockEntity {
    private int wait = 20;
    private int generateCount = 1;
    private BlockPos targetPos;
    private final Item generateItem;

    private final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public int getSlotLimit(int slot) {
            return Math.max(generateCount, 1024);
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return stack.is(generateItem);
        }
    };

    private final LazyOptional<IItemHandler> OPTION = LazyOptional.of(() -> inventory);

    public GeneratorBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState, Item generateItem) {
        super(pType, pPos, pBlockState);
        this.generateItem = generateItem;
    }

    public void tick(Level level) {
        if (level.isClientSide()) return;
        this.wait--;

        if (this.wait == 0) {
            this.wait = 20;
            ItemStack stack = inventory.getStackInSlot(0);
            if (stack.isEmpty()) {
                inventory.setStackInSlot(0, new ItemStack(generateItem, generateCount));
            } else if (stack.getCount() < inventory.getSlotLimit(0)) {
                if (stack.getCount() + generateCount < inventory.getSlotLimit(0)) {
                    stack.grow(generateCount);
                } else {
                    stack.grow(inventory.getSlotLimit(0) - stack.getCount());
                }
            }

            if (targetPos != null && level.isLoaded(targetPos)) {
                BlockEntity targetEntity = level.getBlockEntity(targetPos);
                if (targetEntity != null) {
                    targetEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(targetHandler -> {
                        ItemStack extracted = ItemHandlerHelper.insertItem(targetHandler, inventory.getStackInSlot(0), false);
                        inventory.setStackInSlot(0, extracted);
                    });
                }
            }
        }
    }

    public int getGenerateCount() {
        return generateCount;
    }

    public void addGenerateCount(int value) {
            generateCount += value;
            setChanged();
    }

    @SuppressWarnings("unused")
    public void setGenerateCount(int value) {
        this.generateCount = value;
        setChanged();
    }

    public void setTargetPos(BlockPos pos) {
        targetPos = pos;
        setChanged();
    }

    public void dropItems() {
        if (level == null) return;

        ItemStack stack = inventory.getStackInSlot(0);
        int count = Math.min(stack.getCount(), 1024);
        double result = (double) count / 64;
        double round = Math.floor(result);
        int mod = count % 64;
        int size;
        if (mod == 0) {
            size = (int) result;
        } else {
            size = (int) round + 1;
        }
        SimpleContainer container = new SimpleContainer(size);
        if (mod == 0) {
            for (int i = 0; i < size; i++) {
                container.setItem(i, new ItemStack(stack.getItem(), 64));
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (i != size - 1) {
                    container.setItem(i, new ItemStack(stack.getItem(), 64));
                } else {
                    container.setItem(i, new ItemStack(stack.getItem(), mod));
                }
            }
        }
        Containers.dropContents(level, worldPosition, container);
    }

    public static final String SAVE_INVENTORY = "inventory";
    public static final String SAVE_GENERATE_COUNT = "generate_count";
    public static final String SAVE_TARGET_POS = "target";

    @Override
    public void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put(SAVE_INVENTORY, inventory.serializeNBT());
        pTag.putInt(SAVE_GENERATE_COUNT, generateCount);
        if (targetPos != null) {
            pTag.putLong(SAVE_TARGET_POS, targetPos.asLong());
        }
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        inventory.deserializeNBT(pTag.getCompound(SAVE_INVENTORY));
        if (pTag.contains(SAVE_GENERATE_COUNT)) generateCount = pTag.getInt(SAVE_GENERATE_COUNT);
        if (pTag.contains(SAVE_TARGET_POS)) targetPos = BlockPos.of(pTag.getLong(SAVE_TARGET_POS));
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return OPTION.cast();
        } else {
            return super.getCapability(cap, side);
        }
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        OPTION.invalidate();
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
