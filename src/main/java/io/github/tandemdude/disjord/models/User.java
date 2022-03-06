package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private long id;
    private String username;
    private String discriminator;
    private String avatar;
    private Boolean bot;
    private Boolean system;
    @JsonProperty("mfa_enabled")
    private Boolean mfaEnabled;
    private String banner;
    @JsonProperty("accent_colour")
    private Integer accentColor;
    private String locale;
    private Boolean verified;
    private String email;
    private Integer flags;
    @JsonProperty("premium_type")
    private Integer premiumType;
    @JsonProperty("public_flags")
    private Integer publicFlags;
}
