package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WelcomeScreenChannel {
    @JsonProperty("channel_id")
    private long channelId;
    private String description;
    @JsonProperty("emoji_id")
    private Long emojiId;
    @JsonProperty("emoji_name")
    private String emojiName;
}
