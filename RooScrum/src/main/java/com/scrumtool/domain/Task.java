package com.scrumtool.domain;

import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(inheritanceType="TABLE_PER_CLASS")
public abstract class Task {
	@NotNull
	protected String title;

	protected String description;
	
	protected String remark;
	
    @ManyToOne
    protected Budget budget;
}
