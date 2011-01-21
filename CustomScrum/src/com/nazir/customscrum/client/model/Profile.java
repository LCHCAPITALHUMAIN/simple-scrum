package com.nazir.customscrum.client.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Jan 21, 2011
 * Time: 11:47:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Profile implements Serializable{
    @Id
    public String name;
}
