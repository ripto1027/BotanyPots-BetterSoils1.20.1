package stan.ripto.bettersoils.datagen.client.lang;

public enum TranslateKeys {
    linkedMessage("message.bettersoils.generator.linked"),
    unlinkedMessage("message.bettersoils.generator.unlinked"),
    linkedPosTooltip("tooltip.bettersoils.generator.linked_pos"),
    generateCountTooltip("tooltip.bettersoils.generator.generate_count");

    public final String KEY;

    TranslateKeys(String key) {
        KEY = key;
    }
}
