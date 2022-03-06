package io.github.tandemdude.disjord.models.payloads.gateway;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayHello {
    @JsonProperty("heartbeat_interval")
    private int heartbeatInterval;
}
