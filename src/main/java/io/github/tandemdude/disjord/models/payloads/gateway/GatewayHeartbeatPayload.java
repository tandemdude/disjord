package io.github.tandemdude.disjord.models.payloads.gateway;

import io.github.tandemdude.disjord.models.enums.Opcode;
import lombok.Data;

@Data
public class GatewayHeartbeatPayload {
    private Opcode op = Opcode.HEARTBEAT;
    private Integer d;

    public GatewayHeartbeatPayload(Integer d) {
        this.d = d;
    }
}
