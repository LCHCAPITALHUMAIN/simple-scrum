package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Id;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 06-May-2010
 * Time: 18:28:34
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class BusinessLine extends DomainObject {
    @Id
    public int id;
    public String name;
    public String yettiName;
    public String description;
}
