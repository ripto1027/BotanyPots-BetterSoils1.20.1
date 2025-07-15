package stan.ripto.bettersoils;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;
import stan.ripto.bettersoils.blockentity.BetterSoilsBlockEntities;
import stan.ripto.bettersoils.item.BetterSoilsItems;
import stan.ripto.bettersoils.tab.BetterSoilsTabs;

@Mod(BetterSoils.MOD_ID)
public class BetterSoils {
    public static final String MOD_ID = "bettersoils";

    public BetterSoils(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        BetterSoilsBlocks.BLOCKS.register(bus);
        BetterSoilsItems.ITEMS.register(bus);
        BetterSoilsBlockEntities.BLOCK_ENTITIES.register(bus);
        BetterSoilsTabs.register(bus);
    }
}
