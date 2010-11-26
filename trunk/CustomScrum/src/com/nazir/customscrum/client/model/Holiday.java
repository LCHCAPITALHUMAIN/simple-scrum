package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import java.util.Date;

import org.hibernate.validator.Range;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02-Jun-2010
 * Time: 18:16:58
 * To change this template use File | Settings | File Templates.
 */
public class Holiday extends DomainObject {
    User user;
    Date date;
    //TODO: Values 0.5, 1
    @Range
    float unavailability;
}
