package com.scrumtool.domain;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public abstract class Holiday {
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "S-")
	@NotNull
	private Calendar date;
}
