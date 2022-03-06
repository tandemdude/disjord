package io.github.tandemdude.disjord.models.payloads.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayUnavailableGuild {
    private long id;
    private boolean unavailable;
}
