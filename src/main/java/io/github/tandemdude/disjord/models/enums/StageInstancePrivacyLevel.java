package io.github.tandemdude.disjord.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StageInstancePrivacyLevel {
    PUBLIC(1),
    GUILD_ONLY(2);

    private final int value;

    StageInstancePrivacyLevel(final int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
