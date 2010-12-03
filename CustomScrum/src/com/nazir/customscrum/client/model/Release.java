package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Release extends DomainObject {
    @Id
    int releaseId;
    String applicationVersionNumber;

    String releaseName;
    String description;

    Date contentFreezeDate;
    Date codeFreezeDate;
    Date functionalTestStartDate;
    Date uatStartDate;
    Date signOffDate;
    Date goLiveDate;
    //TODO: Need to find a wat to have this set
    //Set<String> itJiraIds = new HashSet<String>();
    //Set<String> baJiraIds = new HashSet<String>();
}
