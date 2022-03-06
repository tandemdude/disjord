package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {
    private User user;
    private String nick;
    private String avatar;
    private List<Long> roles;
    @JsonProperty("joined_at")
    private String joinedAt;
    @JsonProperty("premium_since")
    private String premiumSince;
    private boolean deaf;
    private boolean mute;
    private Boolean pending;
    private String permissions;
    @JsonProperty("communication_disabled_until")
    private String communicationDisabledUntil;
}
