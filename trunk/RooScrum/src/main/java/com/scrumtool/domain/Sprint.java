package com.scrumtool.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
@RooEntity
public class Sprint {

	@NotNull
	private Integer number;

	@NotNull
	private String title;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "S-")
	private Calendar fromDate;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "S-")
	private Calendar toDate;

	private String description;

	@ManyToOne
	private User globalScrumMaster;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "'T'HH:mm:ss")
	private Date globalStandupTime;

	@NotNull
	private Float estimatedFocusFactor;

	@NotNull
	private Float estimatedAvailability;

	private Float actualFocusFactor;

	private Float actualAvailability;

	@ManyToOne
	private Release release;

	@OneToMany(mappedBy="sprint",cascade = CascadeType.ALL)
	private Set<Team> teams = new HashSet<Team>();

	@OneToMany(mappedBy="sprint", cascade = CascadeType.ALL)
	private Set<SprintDay> days = new HashSet<SprintDay>();

	@OneToMany(mappedBy="sprint",cascade = CascadeType.ALL)
	private Set<DevelopmentTask> developmentTasks = new HashSet<DevelopmentTask>();

	@OneToMany(mappedBy="sprint",cascade = CascadeType.ALL)
	private Set<ManagementTask> managementTasks = new HashSet<ManagementTask>();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Number: ").append(getNumber()).append(", ");
		return sb.toString();
	}
}
