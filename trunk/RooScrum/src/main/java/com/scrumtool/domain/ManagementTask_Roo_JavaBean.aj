// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.domain;

import com.scrumtool.domain.ManagementTaskType;
import com.scrumtool.domain.Sprint;

privileged aspect ManagementTask_Roo_JavaBean {
    
    public Sprint ManagementTask.getSprint() {
        return this.sprint;
    }
    
    public void ManagementTask.setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
    
    public ManagementTaskType ManagementTask.getCategory() {
        return this.category;
    }
    
    public void ManagementTask.setCategory(ManagementTaskType category) {
        this.category = category;
    }
    
}
