package io.github.tandemdude.disjord.models.payloads.gateway;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.tandemdude.disjord.models.enums.Opcode;
import lombok.Data;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GatewaySendPayload {
    @NonNull private Opcode op;
    private Object d;
    private Integer s = null;

    public GatewaySendPayload(@NotNull Opcode op, Object d) {
        this.op = op;
        this.d = d;
    }
}
