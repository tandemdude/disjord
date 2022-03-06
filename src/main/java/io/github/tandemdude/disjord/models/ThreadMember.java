package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThreadMember {
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("join_timestamp")
    private String joinTimestamp;
    private int flags;
}
