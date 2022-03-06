package io.github.tandemdude.disjord.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GuildScheduledEventPrivacyLevel {
    GUILD_ONLY(2);

    private final int value;

    GuildScheduledEventPrivacyLevel(final int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
