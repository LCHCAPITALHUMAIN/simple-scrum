package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Release extends DomainObject {
    @Id
    private int releaseId;
    private String applicationVersionNumber;

    private String releaseName;
    private String description;

    private Date contentFreezeDate;
    private Date codeFreezeDate;
    private Date functionalTestStartDate;
    private Date uatStartDate;
    private Date signOffDate;
    private Date goLiveDate;
}
