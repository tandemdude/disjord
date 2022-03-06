package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Emoji {
    private Long id;
    private String name;
    private List<Long> roles;
    private User user;
    @JsonProperty("require_colons")
    private Boolean requireColons;
    private Boolean managed;
    private Boolean animated;
    private Boolean available;
}
