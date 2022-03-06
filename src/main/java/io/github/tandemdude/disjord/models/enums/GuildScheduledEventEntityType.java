package io.github.tandemdude.disjord.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GuildScheduledEventEntityType {
    STAGE_INSTANCE(1),
    VOICE(2),
    EXTERNAL(3);

    private final int value;

    GuildScheduledEventEntityType(final int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
