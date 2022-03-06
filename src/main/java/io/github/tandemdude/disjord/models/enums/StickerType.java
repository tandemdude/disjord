package io.github.tandemdude.disjord.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StickerType {
    STANDARD(1),
    GUILD(2);

    private final int value;

    StickerType(final int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
