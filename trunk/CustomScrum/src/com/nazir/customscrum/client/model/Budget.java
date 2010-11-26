package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 19-May-2010
 * Time: 17:13:12
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Budget extends DomainObject {
    @Id
    String budgetLine;
    String projectName;
}
