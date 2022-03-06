package io.github.tandemdude.disjord.models.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GatewayBot {
    private String url;
    private int shards;
    @JsonProperty("session_start_limit")
    private SessionStartLimit sessionStartLimit;

    public String getUrlWithParams() {
        return url + "?v=10&encoding=json";
    }
}
