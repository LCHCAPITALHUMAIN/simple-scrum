package com.simplescrum.model;


public enum ProductBacklogItemStatus {
    VALIDATED("Validated"),
    ESTIMATED("Estiamted"),
    PlANIFIED("Planified"),
    INPROGRESS("In Progress"),
    TESTED("Tested"),
    DONE("Done");

    final String description;

    ProductBacklogItemStatus(String description) {
        this.description = description;
    }
}