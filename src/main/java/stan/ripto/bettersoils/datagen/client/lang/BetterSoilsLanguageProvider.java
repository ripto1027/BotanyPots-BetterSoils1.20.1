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
            addBlock(BetterSoilsBlocks.COMPRESSED_DIRT, "Fertile Dirt I");
            addBlock(BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT, "Fertile Dirt II");
            addBlock(BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT, "Fertile Dirt III");
            addBlock(BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT, "Fertile Dirt IV");
            addBlock(BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT, "Fertile Dirt V");
            addBlock(BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT, "Fertile Dirt VI");

            addBlock(BetterSoilsBlocks.DIRT_GENERATOR, "Dirt Generator");

            add(TranslateKeys.linkedMessage.KEY, "Linked to %1$s(%2$d, %3$d, %4$d).");
            add(TranslateKeys.unlinkedMessage.KEY, "The link has been resolved.");
            add(TranslateKeys.linkedPosTooltip.KEY, "Linked to %1$s(%2$d, %3$d, %4$d)");
            add(TranslateKeys.generateCountTooltip.KEY, "Generate Count: %1$d/sec");
        }
    }

    public static class JAJP extends LanguageProvider {
        public JAJP(PackOutput output) {
            super(output, BetterSoils.MOD_ID, "ja_jp");
        }

        @Override
        protected void addTranslations() {
            addBlock(BetterSoilsBlocks.COMPRESSED_DIRT, "肥沃な土");
            addBlock(BetterSoilsBlocks.DOUBLE_COMPRESSED_DIRT, "さらに肥沃な土");
            addBlock(BetterSoilsBlocks.TRIPLE_COMPRESSED_DIRT, "もっと肥沃な土");
            addBlock(BetterSoilsBlocks.QUADRUPLE_COMPRESSED_DIRT, "すごい肥沃な土");
            addBlock(BetterSoilsBlocks.QUINTUPLE_COMPRESSED_DIRT, "やばい肥沃な土");
            addBlock(BetterSoilsBlocks.SEXTUPLE_COMPRESSED_DIRT, "ありえないくらい肥沃な土");

            addBlock(BetterSoilsBlocks.DIRT_GENERATOR, "土生成機");

            add(TranslateKeys.linkedMessage.KEY, "リンク先: %1$s(%2$d, %3$d, %4$d)");
            add(TranslateKeys.unlinkedMessage.KEY, "リンクが解除されました。");
            add(TranslateKeys.linkedPosTooltip.KEY, "リンク先: %1$s(%2$d, %3$d, %4$d)");
            add(TranslateKeys.generateCountTooltip.KEY, "生成量: %1$d/sec");
        }
    }
}
