// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.domain;

import com.scrumtool.domain.User;
import java.lang.String;

privileged aspect ProductBacklog_Roo_JavaBean {
    
    public String ProductBacklog.getProductName() {
        return this.productName;
    }
    
    public void ProductBacklog.setProductName(String productName) {
        this.productName = productName;
    }
    
    public User ProductBacklog.getProductOwner() {
        return this.productOwner;
    }
    
    public void ProductBacklog.setProductOwner(User productOwner) {
        this.productOwner = productOwner;
    }
    
}