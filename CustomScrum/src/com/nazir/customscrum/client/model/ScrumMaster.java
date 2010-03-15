package com.nazir.customscrum.client.model;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 7:57:57 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("ScrumMaster")
public class ScrumMaster extends TeamMember{
}
