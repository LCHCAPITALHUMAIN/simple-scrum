package com.scrumtool.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.scrumtool.domain.SprintDay;
import javax.persistence.ManyToOne;
import com.scrumtool.domain.DevelopmentTask;

@RooJavaBean
@RooToString
@RooEntity
public class Remaining {

    @ManyToOne
    private SprintDay sprintDay;

    @ManyToOne
    private DevelopmentTask task;

    private Float remaining;
}
