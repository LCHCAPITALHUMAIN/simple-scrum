// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.domain;

import java.util.Calendar;

privileged aspect Holiday_Roo_JavaBean {
    
    public Calendar Holiday.getDate() {
        return this.date;
    }
    
    public void Holiday.setDate(Calendar date) {
        this.date = date;
    }
    
}
