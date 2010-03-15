package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.common.JiraType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 7:56:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Task  extends DomainObject{
    @Id
    private long id;
    @OneToOne
    private UserStory userStory;
    //private Developer assignedTo;
    private String title;
    private String description;
    private JiraType jiraType;
    private int jiraNumber;
    private int qcNumber;
    private String baResponsible;
    private EstimateType estimateType;
    private int estimateInManDays;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JiraType getJiraType() {
        return jiraType;
    }

    public void setJiraType(JiraType jiraType) {
        this.jiraType = jiraType;
    }

    public int getJiraNumber() {
        return jiraNumber;
    }

    public void setJiraNumber(int jiraNumber) {
        this.jiraNumber = jiraNumber;
    }

    public int getQcNumber() {
        return qcNumber;
    }

    public void setQcNumber(int qcNumber) {
        this.qcNumber = qcNumber;
    }

    public String getBaResponsible() {
        return baResponsible;
    }

    public void setBaResponsible(String baResponsible) {
        this.baResponsible = baResponsible;
    }

    public EstimateType getEstimateType() {
        return estimateType;
    }

    public void setEstimateType(EstimateType estimateType) {
        this.estimateType = estimateType;
    }

    public int getEstimateInManDays() {
        return estimateInManDays;
    }

    public void setEstimateInManDays(int estimateInManDays) {
        this.estimateInManDays = estimateInManDays;
    }
}
