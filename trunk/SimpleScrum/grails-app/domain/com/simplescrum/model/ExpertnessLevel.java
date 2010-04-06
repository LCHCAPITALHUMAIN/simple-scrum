package com.simplescrum.model;

/**
 * Created by IntelliJ IDEA.
 * User: itux
 * Date: Feb 1, 2010
 * Time: 11:28:59 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ExpertnessLevel {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    final String description;

    ExpertnessLevel(String description) {
        this.description = description;
    }

}
