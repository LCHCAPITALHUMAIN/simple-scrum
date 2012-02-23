// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.domain;

import com.scrumtool.domain.Team;
import com.scrumtool.domain.User;
import com.scrumtool.domain.reference.TeamMemberRole;
import java.lang.Float;
import java.lang.Integer;

privileged aspect TeamMember_Roo_JavaBean {
    
    public User TeamMember.getSrumUser() {
        return this.srumUser;
    }
    
    public void TeamMember.setSrumUser(User srumUser) {
        this.srumUser = srumUser;
    }
    
    public TeamMemberRole TeamMember.getRole() {
        return this.role;
    }
    
    public void TeamMember.setRole(TeamMemberRole role) {
        this.role = role;
    }
    
    public Integer TeamMember.getNonWorkingDaysCount() {
        return this.nonWorkingDaysCount;
    }
    
    public void TeamMember.setNonWorkingDaysCount(Integer nonWorkingDaysCount) {
        this.nonWorkingDaysCount = nonWorkingDaysCount;
    }
    
    public Float TeamMember.getDevelopmentAvailability() {
        return this.developmentAvailability;
    }
    
    public void TeamMember.setDevelopmentAvailability(Float developmentAvailability) {
        this.developmentAvailability = developmentAvailability;
    }
    
    public Team TeamMember.getTeam() {
        return this.team;
    }
    
    public void TeamMember.setTeam(Team team) {
        this.team = team;
    }
    
}