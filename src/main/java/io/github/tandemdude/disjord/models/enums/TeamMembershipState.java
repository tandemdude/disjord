package io.github.tandemdude.disjord.models.enums;

public enum TeamMembershipState {
    INVITED(1),
    ACCEPTED(2);

    private final int value;

    TeamMembershipState(final int value) {
        this.value = value;
    }
}
