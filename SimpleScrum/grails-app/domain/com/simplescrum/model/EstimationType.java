package com.simplescrum.model;


public enum EstimationType {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    final String description;

    EstimationType(String description) {
        this.description = description;
    }
}