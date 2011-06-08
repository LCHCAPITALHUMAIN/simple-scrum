package com.scrumtool.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import com.scrumtool.domain.reference.IssueType;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooEntity
public class Issue {

    @NotNull
    @Column(unique = true)
    private String issueId;

    private String description;

    private String creator;

    private String assignee;

    private String status;

    private Float value;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<com.scrumtool.domain.Issue> subIssues = new HashSet<com.scrumtool.domain.Issue>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<com.scrumtool.domain.Issue> linkedIssues = new HashSet<com.scrumtool.domain.Issue>();

    @Enumerated
    private IssueType type;
}
