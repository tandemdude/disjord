package io.github.tandemdude.disjord.models.payloads.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tandemdude.disjord.models.Application;
import io.github.tandemdude.disjord.models.User;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayReady {
    @JsonProperty("v")
    private int version;
    private User user;
    @JsonProperty("guilds")
    private List<GatewayUnavailableGuild> unavailableGuilds;
    @JsonProperty("session_id")
    private String sessionId;
    private List<Integer> shard;
    private Application application;
}
