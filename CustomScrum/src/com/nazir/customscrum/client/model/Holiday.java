package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import java.util.Date;

import org.hibernate.validator.Range;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02-Jun-2010
 * Time: 18:16:58
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Holiday extends DomainObject {
    @Id
    public HolidayKey key;
    @Range(min = 0, max=1)
    public float unavailability;
}
