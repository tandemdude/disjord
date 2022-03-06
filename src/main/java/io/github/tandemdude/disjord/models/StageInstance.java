package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tandemdude.disjord.models.enums.StageInstancePrivacyLevel;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StageInstance {
    private long id;
    @JsonProperty("guild_id")
    private long guildId;
    @JsonProperty("channel_id")
    private long channelId;
    private String topic;
    @JsonProperty("privacy_level")
    private StageInstancePrivacyLevel privacyLevel;
    @JsonProperty("discoverable_disabled")
    private boolean discoverableDisabled;
}
