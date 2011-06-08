package com.scrumtool.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class Release {

    private String applicationVersionNumber;

    private String releaseName;

    private String description;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "S-")
    private Calendar contentFreezeDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "S-")
    private Calendar codeFreezeDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "S-")
    private Calendar functionalTestStartDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "S-")
    private Calendar uatStartDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "S-")
    private Calendar signOffDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "S-")
    private Calendar goLiveDate;
    
    @ManyToOne
    private ProductBacklog productBacklog;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Sprint> sprints = new HashSet<Sprint>();

}
