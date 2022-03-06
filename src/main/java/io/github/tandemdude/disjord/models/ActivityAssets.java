package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityAssets {
    @JsonProperty("large_image")
    private String largeImage;
    @JsonProperty("large_text")
    private String largeText;
    @JsonProperty("small_image")
    private String smallImage;
    @JsonProperty("small_text")
    private String smallText;
}
