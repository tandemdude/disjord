package io.github.tandemdude.disjord.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StickerFormat {
    PNG(1),
    APNG(2),
    LOTTIE(3);

    private final int value;

    StickerFormat(final int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
