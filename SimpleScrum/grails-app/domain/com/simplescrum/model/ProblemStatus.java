package com.simplescrum.model;


public enum ProblemStatus {
    UNASSIGNED("Unassigned"),
    SOLVING("Solving"),
    SOLVED("Solved");

    final String description;

    ProblemStatus(String description) {
        this.description = description;
    }
}
