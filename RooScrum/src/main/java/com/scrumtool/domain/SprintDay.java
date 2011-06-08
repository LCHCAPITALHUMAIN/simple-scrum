package com.scrumtool.domain;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString(excludeFields={"comments","date"})
@RooEntity
public class SprintDay {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style="S-")
    private Date date;

    private Integer day;

    private String comments;

    @ManyToOne
    private Sprint sprint;
}
