package com.nazir.customscrum.client.model;
import org.hibernate.validator.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.sql.Time;

import com.nazir.customscrum.client.model.util.DomainObject;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 7:56:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@org.hibernate.annotations.Entity()
public class Sprint extends DomainObject {
    @Id
    @Column(name = "num")
    public int number;

    @NotNull
    public String title;

    @NotNull
    public Date fromDate;

    @NotNull
    public Date toDate;

    public String description;

    @OneToMany
    public Set<SprintDay> days;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    public Set<Team> teams;

    public User productOwner;

    @NotNull
    public Time globalStandupTime;

    @NotNull
    public float estimatedFocusFactor;

    @NotNull
    public float estimatedAvailability;

    public float actualFocusFactor;

    public float actualAvailability;

    //TODO: Try to encapsulate tasks and user stories as sprint backlog item
    @OneToMany
    public Set<UserStory> userStories;
    @OneToMany
    public Set<Task> tasks;

    public void setGlobalStandupTime(Time globalStandupTime) {
        this.globalStandupTime = globalStandupTime;
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
