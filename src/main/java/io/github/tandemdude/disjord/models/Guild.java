package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guild {
    private long id;
    private String name;
    private String icon;
    @JsonProperty("icon_hash")
    private String iconHash;
    private String splash;
    @JsonProperty("discovery_hash")
    private String discoveryHash;
    private Boolean owner;
    @JsonProperty("owner_id")
    private long ownerId;
    private String permissions;
    private String region;
    @JsonProperty("afk_channel_id")
    private Long afkChannelId;
    @JsonProperty("afk_timeout")
    private int afkTimeout;
    @JsonProperty("widget_enabled")
    private Boolean widgetEnabled;
    @JsonProperty("widget_channel_id")
    private Long widgetChannelId;
    @JsonProperty("verification_level")
    private int verificationLevel;
    @JsonProperty("default_message_notifications")
    private int defaultMessageNotifications;
    @JsonProperty("explicit_content_filter")
    private int explicitContentFilter;
    private List<Role> roles;
    private List<Emoji> emojis;
    private List<String> features;
    @JsonProperty("mfa_level")
    private int mfaLevel;
    @JsonProperty("application_id")
    private Long applicationId;
    @JsonProperty("system_channel_id")
    private Long systemChannelId;
    @JsonProperty("system_channel_flags")
    private int systemChannelFlags;
    @JsonProperty("rules_channel_id")
    private Long rulesChannelId;
    @JsonProperty("joined_at")
    private String joinedAt;
    private Boolean large;
    private Boolean unavailable;
    @JsonProperty("member_count")
    private Integer memberCount;
    @JsonProperty("voice_states")
    private List<VoiceState> voiceStates;
    private List<Member> members;
    private List<Channel> channels;
    private List<Channel> threads;
    private List<Presence> presences;
    @JsonProperty("max_presences")
    private Integer maxPresences;
    @JsonProperty("max_members")
    private Integer maxMembers;
    @JsonProperty("vanity_url_code")
    private String vanityUrlCode;
    private String description;
    private String banner;
    @JsonProperty("premium_tier")
    private int premiumTier;
    @JsonProperty("premium_subscription_count")
    private Integer premiumSubscriptionCount;
    @JsonProperty("preferred_locale")
    private String preferredLocale;
    @JsonProperty("public_updates_channel_id")
    private Long publicUpdatesChannelId;
    @JsonProperty("max_video_channel_users")
    private Integer maxVideoChannelUsers;
    @JsonProperty("approximate_member_count")
    private Integer approximateMemberCount;
    @JsonProperty("approximate_presence_count")
    private Integer approximatePresenceCount;
    @JsonProperty("welcome_screen")
    private WelcomeScreen welcomeScreen;
    @JsonProperty("nsfw_level")
    private int nsfwLevel;
    @JsonProperty("stage_instances")
    private List<StageInstance> stageInstances;
    private List<Sticker> stickers;
    @JsonProperty("guild_scheduled_events")
    private List<GuildScheduledEvent> guildScheduledEvents;
    @JsonProperty("premium_progress_bar_enabled")
    private boolean premiumProgressBarEnabled;
}
