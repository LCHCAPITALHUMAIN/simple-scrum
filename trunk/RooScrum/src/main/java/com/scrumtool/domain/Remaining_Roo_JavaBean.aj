// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.domain;

import com.scrumtool.domain.DevelopmentTask;
import com.scrumtool.domain.SprintDay;
import java.lang.Float;

privileged aspect Remaining_Roo_JavaBean {
    
    public SprintDay Remaining.getSprintDay() {
        return this.sprintDay;
    }
    
    public void Remaining.setSprintDay(SprintDay sprintDay) {
        this.sprintDay = sprintDay;
    }
    
    public DevelopmentTask Remaining.getTask() {
        return this.task;
    }
    
    public void Remaining.setTask(DevelopmentTask task) {
        this.task = task;
    }
    
    public Float Remaining.getRemaining() {
        return this.remaining;
    }
    
    public void Remaining.setRemaining(Float remaining) {
        this.remaining = remaining;
    }
    
}