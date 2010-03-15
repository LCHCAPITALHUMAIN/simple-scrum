package com.nazir.customscrum.client.model;
import org.hibernate.validator.NotNull;
import org.hibernate.annotations.LazyToOne;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 7:56:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@org.hibernate.annotations.Entity()
public class Sprint extends DomainObject{
    @Id
    private int number;
    @NotNull
    private String title;
    @NotNull
    private Date fromDate;
    @NotNull
    private Date toDate;
    private String description;
    @NotNull
    private SprintStatus status;
    @OneToMany
    private Set<SprintDay> days;
    @OneToMany
    private Set<Team> teams;
    @NotNull
    private Date globalStandupTime;
    @NotNull
    private int focusFactor;
    @NotNull
    private int availability;
    @OneToMany
    private Set<UserStory> userStories;
    @OneToMany
    private Set<Task> tasks;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SprintStatus getStatus() {
        return status;
    }

    public void setStatus(SprintStatus status) {
        this.status = status;
    }

    public Set<SprintDay> getDays() {
        return days;
    }

    public void setDays(Set<SprintDay> days) {
        this.days = days;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Date getGlobalStandupTime() {
        return globalStandupTime;
    }

    public void setGlobalStandupTime(Date globalStandupTime) {
        this.globalStandupTime = globalStandupTime;
    }

    public int getFocusFactor() {
        return focusFactor;
    }

    public void setFocusFactor(int focusFactor) {
        this.focusFactor = focusFactor;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Set<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(Set<UserStory> userStories) {
        this.userStories = userStories;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
