package com.scrumtool.domain;

import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.scrumtool.domain.reference.TeamMemberRole;

@RooJavaBean
@RooToString
@RooEntity
public class TeamMember {

	@ManyToOne
	private User srumUser;

	@Enumerated
	private TeamMemberRole role;

	private Integer nonWorkingDaysCount;

	@Min(0L)
	@Max(1L)
	private Float developmentAvailability;

	@ManyToOne
	private Team team;
}
