package stan.ripto.bettersoils.block;

import stan.ripto.bettersoils.blockentity.BetterSoilsBlockEntities;
import stan.ripto.bettersoils.blockentity.CobblestoneGeneratorBlockEntity;

public class CobblestoneGeneratorBlock extends GeneratorBlock<CobblestoneGeneratorBlockEntity> {
    public CobblestoneGeneratorBlock() {
        super(BlockData.COBBLESTONE_GENERATOR.PROP, BetterSoilsBlockEntities.COBBLESTONE_GENERATOR, CobblestoneGeneratorBlockEntity::new, CobblestoneGeneratorBlockEntity.class);
    }
}
