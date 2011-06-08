package com.scrumtool.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.scrumtool.domain.TeamMember;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import com.scrumtool.domain.reference.HolidayDuration;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooEntity
public class DayOff extends Holiday {

    @NotNull
    @ManyToOne
    private TeamMember teamMember;

    @Enumerated
    private HolidayDuration category;
}
