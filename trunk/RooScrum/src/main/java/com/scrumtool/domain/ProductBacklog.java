package com.scrumtool.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import com.scrumtool.domain.User;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class ProductBacklog {

    private String productName;

    @ManyToOne
    private User productOwner;
}
