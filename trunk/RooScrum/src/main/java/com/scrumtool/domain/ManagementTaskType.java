package com.scrumtool.domain;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class ManagementTaskType {

    @NotNull
    private String name;
    
    @ManyToOne(optional=true)
    private ManagementTaskType parent;
}
