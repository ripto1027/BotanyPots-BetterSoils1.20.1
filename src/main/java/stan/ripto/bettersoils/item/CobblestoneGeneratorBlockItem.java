package stan.ripto.bettersoils.item;

import stan.ripto.bettersoils.block.BetterSoilsBlocks;
import stan.ripto.bettersoils.blockentity.CobblestoneGeneratorBlockEntity;

public class CobblestoneGeneratorBlockItem extends GeneratorBlockItem<CobblestoneGeneratorBlockEntity> {
    public CobblestoneGeneratorBlockItem() {
        super(BetterSoilsBlocks.COBBLESTONE_GENERATOR.get(), CobblestoneGeneratorBlockEntity.class);
    }
}
