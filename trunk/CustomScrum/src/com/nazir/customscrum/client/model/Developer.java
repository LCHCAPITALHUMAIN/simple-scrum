package com.nazir.customscrum.client.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 8:17:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("Developer")
public class Developer extends TeamMember{
}
