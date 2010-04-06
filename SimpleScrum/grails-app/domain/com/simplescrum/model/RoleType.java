package com.simplescrum.model;


public enum RoleType {
    SCRUM_MASTER("Scrum Master"),
    PRODUCT_OWNER("Product Owner"),
    STAKE_HOLDER("Stake Holder"),
    DEVELOPER("Developer");

    final String description;

    RoleType(String description) {
        this.description = description;
    }
}