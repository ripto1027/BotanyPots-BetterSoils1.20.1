package stan.ripto.bettersoils.tab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;

public class BetterSoilsTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterSoils.MOD_ID);

    public static void register(IEventBus bus) {
        TABS.register(
                "better_soils_tab",
                () -> CreativeModeTab
                        .builder()
                        .title(Component.literal("Botany Pots: Better Soils"))
                        .icon(BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT.get().asItem()::getDefaultInstance)
                        .displayItems((param, output) -> {
                            BetterSoilsBlocks.blockRegistryList.forEach(element -> output.accept(element.get()));
                            output.accept(BetterSoilsBlocks.DIRT_GENERATOR.get());
                        })
                        .build()
        );
        TABS.register(bus);
    }
}
