package com.scrumtool.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import com.scrumtool.domain.Profile;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity(table="scrum_user")
public class User {

    @NotNull
    @Column(unique = true)
    private String uid;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String emailAddress;
    
    private String jiraUserName;
    
    @NotNull
    @ManyToOne
    private Profile profile;
    
    @NotNull
    @ManyToOne
    private Location location;
}
