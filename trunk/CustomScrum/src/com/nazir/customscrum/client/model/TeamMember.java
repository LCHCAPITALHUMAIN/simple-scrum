package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.*;


@Entity
public abstract class TeamMember extends DomainObject {
    @Id
    private User t_user;
    private Team team;
    private TeamMemberRole teamMemberRole;
    private int nonWorkingDaysCount;
    //TODO: range 0...1
    private int developmentAvailability;
    private String jiraUserName;


}
