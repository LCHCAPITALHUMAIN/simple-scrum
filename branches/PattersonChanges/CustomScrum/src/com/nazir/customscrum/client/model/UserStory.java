package com.nazir.customscrum.client.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class UserStory extends UserStorySkeleton {
    @Id
    public long backlogId;

    public String name;

    //TODO: revert this back
//    public Set<String> functionalSpecId;

    @OneToMany
    public Set<Documentation> documentation;

    @OneToMany
    public Set<AcceptanceCriteria> accCriteria;

    @OneToMany
    public Set<Task> tasks;

    //Estimate estimate;

    long importance;

    int priority;

    Module module;

    String remark;

    public String functionalJiraNumber;

    public int functionalQcNumber;
    public String title;
    public String jiraNumber;
    public int qcNumber;
    public String description;
    public String linkToTheSpec;
    public String baResponsible;
    @OneToOne
    public Estimate estimate;
    @OneToOne
    public Release release;
    public String rationals;
    @OneToOne
    public BusinessLine businessLine;
    @OneToOne
    public Status status;
}