package stan.ripto.bettersoils.block;

import stan.ripto.bettersoils.blockentity.BetterSoilsBlockEntities;
import stan.ripto.bettersoils.blockentity.DirtGeneratorBlockEntity;

public class DirtGeneratorBlock extends GeneratorBlock<DirtGeneratorBlockEntity> {
    public DirtGeneratorBlock() {
        super(BlockData.DIRT_GENERATOR.PROP, BetterSoilsBlockEntities.DIRT_GENERATOR, DirtGeneratorBlockEntity::new, DirtGeneratorBlockEntity.class);
    }
}
