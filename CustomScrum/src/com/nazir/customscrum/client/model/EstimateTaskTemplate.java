package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02-Jun-2010
 * Time: 19:03:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class EstimateTaskTemplate extends DomainObject{
    @Id
    long id;
    String taskType;
    String taskDescription;
}
