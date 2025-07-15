package stan.ripto.bettersoils.datagen.server.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;

import java.util.List;
import java.util.Set;

public class BetterSoilsLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(BetterSoilsSubProvider::new, LootContextParamSets.BLOCK)));
    }

    private static class BetterSoilsSubProvider extends BlockLootSubProvider {
        protected BetterSoilsSubProvider() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            BetterSoilsBlocks.blockRegistryList.forEach(element -> dropSelf(element.get()));
            dropSelf(BetterSoilsBlocks.DIRT_GENERATOR.get());
            dropSelf(BetterSoilsBlocks.COBBLESTONE_GENERATOR.get());
        }

        @Override
        @NotNull
        protected Iterable<Block> getKnownBlocks() {
            return BetterSoilsBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }
    }

}
