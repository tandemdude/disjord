package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoiceState {
    @JsonProperty("guild_id")
    private Long guildId;
    @JsonProperty("channel_id")
    private Long channelId;
    @JsonProperty("user_id")
    private Long userId;
    private Member member;
    @JsonProperty("session_id")
    private String sessionId;
    private boolean deaf;
    private boolean mute;
    @JsonProperty("self_deaf")
    private boolean selfDeaf;
    @JsonProperty("self_mute")
    private boolean selfMute;
    @JsonProperty("self_stream")
    private Boolean selfStream;
    @JsonProperty("self_video")
    private Boolean selfVideo;
    private boolean suppress;
    @JsonProperty("request_to_speak_timestamp")
    private String requestToSpeakTimestamp;
}
