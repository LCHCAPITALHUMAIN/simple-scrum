package com.simplescrum.model;

public enum ReleaseStatus {
    OPEN("Open"),
    LOCKED("Locked"),
    DONE("Done");

    final String description;

    ReleaseStatus(String description) {
        this.description = description;
    }
}