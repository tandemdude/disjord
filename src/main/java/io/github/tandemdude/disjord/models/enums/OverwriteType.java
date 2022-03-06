package io.github.tandemdude.disjord.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OverwriteType {
    ROLE(0),
    MEMBER(1);

    private final int value;

    OverwriteType(final int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
