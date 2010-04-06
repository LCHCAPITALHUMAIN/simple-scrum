package com.simplescrum.model;

public enum ReleaseType {
    NORMAL("Normal"),
    FIXED_END_DATE("Fixed End Date"),
    FIXED_VELOCITY("Fixed Velocity");

    final String description;

    ReleaseType(String description) {
        this.description = description;
    }
}

