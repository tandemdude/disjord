package io.github.tandemdude.disjord.models.payloads.gateway;

import lombok.Data;

@Data
public class GatewayIdentify {
    private String token;
    private GatewayConnectionProperties properties = new GatewayConnectionProperties();
    private boolean compress = false;
    private int intents = 32509;  // all unprivileged

    public GatewayIdentify(String token) {
        this.token = token;
    }
}
