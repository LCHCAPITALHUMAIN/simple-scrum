package com.nazir.customscrum.client.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 7:57:42 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="memberType",
    discriminatorType= DiscriminatorType.STRING
)
public abstract class TeamMember extends DomainObject{
    @Id
    private String userName;
}
