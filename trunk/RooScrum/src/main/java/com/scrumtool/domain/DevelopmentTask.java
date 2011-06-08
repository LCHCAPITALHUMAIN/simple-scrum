package com.scrumtool.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.scrumtool.domain.reference.TaskStatus;
import com.scrumtool.domain.reference.DevelopmentTaskType;

@RooJavaBean
@RooToString
@RooEntity
public class DevelopmentTask extends Task {
    @ManyToOne
    private Sprint sprint;
    
    @ManyToOne
    private Issue issue;

    @ManyToOne
    private User bussinessAnalyst;

    @ManyToOne
    private Module module;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Team> teamsInCharge = new HashSet<Team>();

    @OneToMany(mappedBy="task", cascade = CascadeType.ALL)
    private Set<Estimate> estimates = new HashSet<Estimate>();

    @OneToMany(mappedBy="task",cascade = CascadeType.ALL)
    private Set<Actual> actuals = new HashSet<Actual>();

    @OneToMany(mappedBy="task",cascade = CascadeType.ALL)
    private Set<Remaining> remainings = new HashSet<Remaining>();

    @Enumerated
    private TaskStatus status;

    @Enumerated
    private DevelopmentTaskType type;
}
