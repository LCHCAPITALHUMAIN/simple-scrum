package com.scrumtool.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Set;
import com.scrumtool.domain.TeamMember;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import com.scrumtool.domain.Sprint;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class Team {

    private String name;

    private Float estimatedFocusFactor;

    @OneToMany(mappedBy="team", cascade = CascadeType.ALL)
    private Set<TeamMember> teamMembers = new HashSet<TeamMember>();

    @ManyToOne
    private Sprint sprint;
}
