package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private String icon;
    private long id;
    private List<TeamMember> members;
    private String name;
    @JsonProperty("owner_user_id")
    private long ownerUserId;
}
