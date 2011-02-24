package com.nazir.customscrum.client.model;
import org.hibernate.validator.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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
    public Set<Team> teams = new HashSet<Team>();

    @ManyToOne
    public User productOwner;

    @ManyToOne
    public User globalScrumMaster;

    @NotNull
    public Time globalStandupTime;

    @NotNull
    public float estimatedFocusFactor;

    @NotNull
    public float estimatedAvailability;

    public float actualFocusFactor;

    public float actualAvailability;

    @OneToMany
    public Set<Task> tasks;

    public void setGlobalStandupTime(Time globalStandupTime) {
        this.globalStandupTime = globalStandupTime;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

}
