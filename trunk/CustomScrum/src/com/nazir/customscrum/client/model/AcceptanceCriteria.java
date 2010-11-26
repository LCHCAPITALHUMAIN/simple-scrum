package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Id;
import javax.persistence.Entity;

import org.hibernate.validator.Range;
import org.hibernate.validator.Length;
import org.hibernate.validator.Size;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02-Jun-2010
 * Time: 17:15:53
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class AcceptanceCriteria extends DomainObject {
    @Id
    Long id;

    @Size(max=5000) //TODO Size has no impact on PDM
    String criteria;
}
