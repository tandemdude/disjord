package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tandemdude.disjord.models.enums.ChannelType;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {
    private long id;
    private ChannelType type;
    @JsonProperty("guild_id")
    private Long guildId;
    private Integer position;
    @JsonProperty("permission_overwrites")
    private List<PermissionOverwrite> permissionOverwrites;
    private String name;
    private String topic;
    private Boolean nsfw;
    @JsonProperty("last_message_id")
    private Long lastMessageId;
    private Integer bitrate;
    @JsonProperty("user_limit")
    private Integer userLimit;
    @JsonProperty("rate_limit_per_user")
    private Integer rateLimitPerUser;
    private List<User> recipients;
    private String icon;
    @JsonProperty("owner_id")
    private Long ownerId;
    @JsonProperty("application_id")
    private Long applicationId;
    @JsonProperty("parent_id")
    private Long parent_id;
    @JsonProperty("last_pin_timestamp")
    private String lastPinTimestamp;
    @JsonProperty("rtc_region")
    private String rtcRegion;
    @JsonProperty("video_quality_mode")
    private Integer videoQualityMode;
    @JsonProperty("message_count")
    private Integer messageCount;
    @JsonProperty("member_count")
    private Integer memberCount;
    @JsonProperty("thread_metadata")
    private ThreadMetadata threadMetadata;
    private ThreadMember member;
    @JsonProperty("default_auto_archive_duration")
    private Integer defaultAutoArchiveDuration;
    private String permissions;
}
