package stan.ripto.bettersoils.blockentity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;
import stan.ripto.bettersoils.block.BlockData;

public class BetterSoilsBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BetterSoils.MOD_ID);

    public static final RegistryObject<BlockEntityType<DirtGeneratorBlockEntity>> DIRT_GENERATOR = BLOCK_ENTITIES.register(
            BlockData.DIRT_GENERATOR.NAME,
            () -> BlockEntityType
                    .Builder.of(
                            DirtGeneratorBlockEntity::new,
                            BetterSoilsBlocks.DIRT_GENERATOR.get()
                    )
                    .build(null)
    );

    public static final RegistryObject<BlockEntityType<CobblestoneGeneratorBlockEntity>> COBBLESTONE_GENERATOR = BLOCK_ENTITIES.register(
            BlockData.COBBLESTONE_GENERATOR.NAME,
            () -> BlockEntityType
                    .Builder.of(
                            CobblestoneGeneratorBlockEntity::new,
                            BetterSoilsBlocks.COBBLESTONE_GENERATOR.get()
                    )
                    .build(null)
    );
}
