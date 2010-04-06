package com.simplescrum.model;

public enum TaskType {
    PLANNED("Planned"),
    UN_PLANNED("Unplanned");

    final String description;

    TaskType(String description) {
        this.description = description;
    }
}
