package stan.ripto.bettersoils.item;

import stan.ripto.bettersoils.block.BetterSoilsBlocks;
import stan.ripto.bettersoils.blockentity.DirtGeneratorBlockEntity;

public class DirtGeneratorBlockItem extends GeneratorBlockItem<DirtGeneratorBlockEntity> {
    public DirtGeneratorBlockItem() {
        super(BetterSoilsBlocks.DIRT_GENERATOR.get(), DirtGeneratorBlockEntity.class);
    }
}
