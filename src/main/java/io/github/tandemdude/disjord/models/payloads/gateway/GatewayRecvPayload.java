package io.github.tandemdude.disjord.models.payloads.gateway;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.tandemdude.disjord.models.enums.Opcode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRecvPayload {
    @JsonProperty("op")
    @NonNull private Opcode opcode;
    @JsonProperty("d")
    private JsonNode data;
    @JsonProperty("s")
    private Integer sequence;
    @JsonProperty("t")
    private String eventType;

    public <T> T deserialiseData(ObjectMapper objectMapper, Class<T> targetClass) {
        try {
            return objectMapper.treeToValue(data, targetClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
