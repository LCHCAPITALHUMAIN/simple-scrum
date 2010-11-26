package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 8:02:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Team  extends DomainObject {
    @Id
    private String name;

    @OneToOne
    private Sprint sprint;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<TeamMember> teamMembers;

    private float estimatedFocusFactor;
}
