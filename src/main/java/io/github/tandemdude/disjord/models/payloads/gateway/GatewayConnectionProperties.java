package io.github.tandemdude.disjord.models.payloads.gateway;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class GatewayConnectionProperties {
    @Getter
    @JsonProperty("$os")
    private String os = "macOS Monterey (12.0.1)";
    @Getter
    @JsonProperty("$browser")
    private String browser = "Disjord (0.0.0, OkHttp3 4.9.3)";
    @Getter
    @JsonProperty("$device")
    private String device = "Disjord";
}
