package com.nazir.customscrum.client.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Feb 24, 2011
 * Time: 11:26:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Location extends DomainObject{
    @Id
    public String code;
    public String name;
}
