package com.scrumtool.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.scrumtool.domain.reference.EstimateType;

@RooJavaBean
@RooToString
@RooEntity
public class Estimate {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "S-")
    private Calendar date;

    @Enumerated
    private EstimateType type;

    private Float value;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> estimators = new HashSet<User>();
    
    @ManyToOne
    @NotNull
    private Task task;

    private String rationales;

    private String comments;
}
