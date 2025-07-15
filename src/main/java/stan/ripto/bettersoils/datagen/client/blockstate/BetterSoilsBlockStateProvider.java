package stan.ripto.bettersoils.datagen.client.blockstate;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;

public class BetterSoilsBlockStateProvider extends BlockStateProvider {
    public BetterSoilsBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BetterSoils.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BetterSoilsBlocks.blockRegistryList.forEach(element -> simpleBlockWithItem(element.get(), cubeAll(element.get())));
        horizontalBlock(BetterSoilsBlocks.DIRT_GENERATOR.get());
        horizontalBlock(BetterSoilsBlocks.COBBLESTONE_GENERATOR.get());
    }

    private void horizontalBlock(Block generator) {
        ResourceLocation genLoc = ForgeRegistries.BLOCKS.getKey(generator);

        if (genLoc == null) return;
        String name = genLoc.getPath();

        ResourceLocation loc = modLoc("block/generator");
        ResourceLocation faceLoc = modLoc("block/" + name + "_front");

        BlockModelBuilder model = models().orientable(name, loc, faceLoc, loc);

        horizontalBlock(generator, model);
        simpleBlockItem(generator, model);
    }
}
