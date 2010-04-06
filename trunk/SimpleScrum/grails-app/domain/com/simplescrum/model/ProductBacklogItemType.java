package com.simplescrum.model;


public enum ProductBacklogItemType {
    USER_STORY("User Story"),
    FEATURE("Feature"),
    TEAM_MANAGEMENT("Team Management"),
    TECHNICAL_STORY("Technical Story"),
    DEFECT("Defect");

    final String description;

    ProductBacklogItemType(String description) {
        this.description = description;
    }
}