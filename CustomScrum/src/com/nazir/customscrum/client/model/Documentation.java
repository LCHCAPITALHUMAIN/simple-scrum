package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Id;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 19-May-2010
 * Time: 16:12:17
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Documentation extends DomainObject{
    @Id
    public int id;

    public String documentType;
    public String location;


}
