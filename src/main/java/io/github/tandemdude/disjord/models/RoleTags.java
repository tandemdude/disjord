package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleTags {
    @JsonProperty("bot_id")
    private Long botId;
    @JsonProperty("integration_id")
    private Long integrationId;
    @JsonProperty("premium_subscriber")
    private String premiumSubscriber;
}
