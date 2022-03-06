package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Presence {
    private User user;
    @JsonProperty("guild_id")
    private long guildId;
    private String status;
    private List<Activity> activities;
    @JsonProperty("client_status")
    private ClientStatus clientStatus;
}
