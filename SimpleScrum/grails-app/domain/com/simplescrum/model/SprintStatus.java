package com.simplescrum.model;


public enum SprintStatus {
    OPEN("Open"),
    LOCKED("Locked"),
    DONE("Done");

    final String description;

    SprintStatus(String description) {
        this.description = description;
    }
}