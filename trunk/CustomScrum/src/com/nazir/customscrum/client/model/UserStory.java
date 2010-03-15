package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.common.JiraType;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 7:56:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class UserStory  extends DomainObject{
    @Id
    public long backlogId;
    public String title;
    public JiraType jiraType;
    public int jiraNumber;
    public int qcNumber;
    public String description;
    public String linkToTheSpec;
    public String baResponsible;
    public EstimateType estimateType;
    public int estimateInManDays;
    
    
}
