package io.github.tandemdude.disjord.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tandemdude.disjord.models.enums.TeamMembershipState;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMember {
    @JsonProperty("membership_state")
    private TeamMembershipState membershipState;
    private List<String> permissions;
    @JsonProperty("team_id")
    private long teamId;
    private User user;
}
