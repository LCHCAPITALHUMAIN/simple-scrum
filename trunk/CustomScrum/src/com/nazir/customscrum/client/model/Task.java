package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

import java.util.Set;
import java.util.List;

import org.hibernate.validator.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 7:56:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Task  extends DomainObject {
    @Id
    private long id;
    public TaskType taskType;
    @OneToOne
    public UserStory userStory;
    @NotNull
    public String title;
    public String description;
    public String itJiraNumber;
    public int itQcNumber;
    public String baResponsible;
    //TODO: Add List of estimate
    @OneToMany
    public List<Estimate> estimate;

    @OneToMany
    public Set<Remaining> remainings;

    //TODO
//    @OneToMany
//    public Set<Actual> actuals;

    public Budget budget;
    String remark;
    //TODO common between user story and task
    Status status;

    @OneToMany
    Set<Team> teamInCharge;

}
