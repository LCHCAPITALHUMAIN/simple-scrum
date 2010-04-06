package com.simplescrum.model;

public enum TaskStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    final String description;

    TaskStatus(String description) {
        this.description = description;
    }
}