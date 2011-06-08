package com.scrumtool.domain;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Actual {

    @ManyToOne
    private Task task;

    @ManyToOne
    private TeamMember teamMember;

    @Min(0L)
    @Max(1L)
    private Float daySpent;
}
