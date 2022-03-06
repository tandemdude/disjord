package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tandemdude.disjord.models.enums.GuildScheduledEventEntityType;
import io.github.tandemdude.disjord.models.enums.GuildScheduledEventPrivacyLevel;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildScheduledEvent {
    private long id;
    @JsonProperty("guild_id")
    private long guildId;
    @JsonProperty("channel_id")
    private Long channelId;
    @JsonProperty("creator_id")
    private Long creatorId;
    private String name;
    private String description;
    @JsonProperty("scheduled_start_time")
    private String scheduledStartTime;
    @JsonProperty("scheduled_end_time")
    private String scheduledEndTime;
    @JsonProperty("privacy_level")
    private GuildScheduledEventPrivacyLevel privacyLevel;
    private int status;
    @JsonProperty("entity_type")
    private GuildScheduledEventEntityType entityType;
    @JsonProperty("entity_id")
    private int entityId;
    @JsonProperty("entity_metadata")
    private GuildScheduledEventEntityMetadata entityMetadata;
    private User creator;
    private String image;
}
