package io.github.tandemdude.disjord.models.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SessionStartLimit {
    private int total;
    private int remaining;
    @JsonProperty("reset_after")
    private long resetAfter;
    @JsonProperty("max_concurrency")
    private int maxConcurrency;
}
