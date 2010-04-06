package com.simplescrum.model;


public enum UsageFrequency {
    HOUR("Hur"),
    DAY("Day"),
    WEEK("Week"),
    MONTH("Month"),
    TRIMESTER("Trimester");

    final String description;

    UsageFrequency(String description) {
        this.description = description;
    }
}
