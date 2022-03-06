package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tandemdude.disjord.models.enums.ActivityType;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    private String name;
    private ActivityType type;
    private String url;
    @JsonProperty("created_at")
    private int createdAt;
    private ActivityTimestamps timestamps;
    @JsonProperty("application_id")
    private Long applicationId;
    private String details;
    private String state;
    private ActivityEmoji emoji;
    private ActivityParty party;
    private ActivityAssets assets;
    private ActivitySecrets secrets;
    private Boolean instance;
    private Integer flags;
    private List<ActivityButton> buttons;
}
