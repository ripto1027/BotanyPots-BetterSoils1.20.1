package stan.ripto.bettersoils.datagen.client.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import stan.ripto.bettersoils.BetterSoils;
import stan.ripto.bettersoils.block.BetterSoilsBlocks;

public class BetterSoilsLanguageProvider {
    public static class ENUS extends LanguageProvider {
        public ENUS(PackOutput output) {
            super(output, BetterSoils.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            addBlock(BetterSoilsBlocks.COMPRESSED_DIRT, "Compressed Dirt");
            addBlock(BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT, "Double Compressed Dirt");
            addBlock(BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT, "Triple Compressed Dirt");
            addBlock(BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT, "Quadruple Compressed Dirt");
            addBlock(BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT, "Quintuple Compressed Dirt");
            addBlock(BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT, "Sextuple Compressed Dirt");

            addBlock(BetterSoilsBlocks.COMPRESSED_COBBLESTONE, "Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.DOUBLE_COMPRESSED_COBBLESTONE, "Double Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.TRIPLE_COMPRESSED_COBBLESTONE, "Triple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE, "Quadruple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE, "Quintuple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE, "Sextuple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.SEPTUPLE_COMPRESSED_COBBLESTONE, "Septuple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.OCTUPLE_COMPRESSED_COBBLESTONE, "Octuple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.NONTUPLE_COMPRESSED_COBBLESTONE, "Nontuple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.DECUPLE_COMPRESSED_COBBLESTONE, "Decuple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.UNDECUPLE_COMPRESSED_COBBLESTONE, "Undecuple Compressed Cobblestone");
            addBlock(BetterSoilsBlocks.DUODECUPLE_COMPRESSED_COBBLESTONE, "Duodecuple Compressed Cobblestone");

            addBlock(BetterSoilsBlocks.DIRT_GENERATOR, "Dirt Generator");
            addBlock(BetterSoilsBlocks.COBBLESTONE_GENERATOR, "Cobblestone Generator");

            add(TranslateKeys.linkedMessage.KEY, "Linked to %1$s(%2$d, %3$d, %4$d).");
            add(TranslateKeys.unlinkedMessage.KEY, "The link has been resolved.");
            add(TranslateKeys.linkedPosTooltip.KEY, "Linked to %1$s(%2$d, %3$d, %4$d)");
            add(TranslateKeys.generateCountTooltip.KEY, "Generate Count: %1$d/tick");
        }
    }

    public static class JAJP extends LanguageProvider {
        public JAJP(PackOutput output) {
            super(output, BetterSoils.MOD_ID, "ja_jp");
        }

        @Override
        protected void addTranslations() {
            addBlock(BetterSoilsBlocks.COMPRESSED_DIRT, "圧縮土");
            addBlock(BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT, "2倍圧縮土");
            addBlock(BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT, "3倍圧縮土");
            addBlock(BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT, "4倍圧縮土");
            addBlock(BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT, "5倍圧縮土");
            addBlock(BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT, "6倍圧縮土");

            addBlock(BetterSoilsBlocks.COMPRESSED_COBBLESTONE, "圧縮丸石");
            addBlock(BetterSoilsBlocks.DOUBLE_COMPRESSED_COBBLESTONE, "2倍圧縮丸石");
            addBlock(BetterSoilsBlocks.TRIPLE_COMPRESSED_COBBLESTONE, "3倍圧縮丸石");
            addBlock(BetterSoilsBlocks.QUADRUPLE_COMPRESSED_COBBLESTONE, "4倍圧縮丸石");
            addBlock(BetterSoilsBlocks.QUINTUPLE_COMPRESSED_COBBLESTONE, "5倍圧縮丸石");
            addBlock(BetterSoilsBlocks.SEXTUPLE_COMPRESSED_COBBLESTONE, "6倍圧縮丸石");
            addBlock(BetterSoilsBlocks.SEPTUPLE_COMPRESSED_COBBLESTONE, "7倍圧縮丸石");
            addBlock(BetterSoilsBlocks.OCTUPLE_COMPRESSED_COBBLESTONE, "8倍圧縮丸石");
            addBlock(BetterSoilsBlocks.NONTUPLE_COMPRESSED_COBBLESTONE, "9倍圧縮丸石");
            addBlock(BetterSoilsBlocks.DECUPLE_COMPRESSED_COBBLESTONE, "10倍圧縮丸石");
            addBlock(BetterSoilsBlocks.UNDECUPLE_COMPRESSED_COBBLESTONE, "11倍圧縮丸石");
            addBlock(BetterSoilsBlocks.DUODECUPLE_COMPRESSED_COBBLESTONE, "12倍圧縮丸石");

            addBlock(BetterSoilsBlocks.DIRT_GENERATOR, "土生成機");
            addBlock(BetterSoilsBlocks.COBBLESTONE_GENERATOR, "丸石生成機");

            add(TranslateKeys.linkedMessage.KEY, "リンク先: %1$s(%2$d, %3$d, %4$d)");
            add(TranslateKeys.unlinkedMessage.KEY, "リンクが解除されました。");
            add(TranslateKeys.linkedPosTooltip.KEY, "リンク先: %1$s(%2$d, %3$d, %4$d)");
            add(TranslateKeys.generateCountTooltip.KEY, "生成量: %1$d/tick");
        }
    }
}
