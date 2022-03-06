package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WelcomeScreen {
    private String description;
    @JsonProperty("welcome_channels")
    private List<WelcomeScreenChannel> welcomeChannels;
}
