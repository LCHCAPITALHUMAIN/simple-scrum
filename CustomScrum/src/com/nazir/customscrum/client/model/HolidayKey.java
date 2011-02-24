package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;
import org.hibernate.validator.Range;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02-Jun-2010
 * Time: 18:16:58
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class HolidayKey implements DomainObjectKey {
    public Location location;
    public Date date;
}
