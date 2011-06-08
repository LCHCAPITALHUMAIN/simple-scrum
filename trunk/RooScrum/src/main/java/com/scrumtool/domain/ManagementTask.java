package com.scrumtool.domain;

import javax.persistence.ManyToOne;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public class ManagementTask extends Task {
    @ManyToOne
    private Sprint sprint;
	@ManyToOne
	private ManagementTaskType category;
}
