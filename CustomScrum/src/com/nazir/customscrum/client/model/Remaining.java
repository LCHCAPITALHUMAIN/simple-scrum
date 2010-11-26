package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 11-May-2010
 * Time: 15:20:15
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Remaining extends DomainObject {
    @Id()
    SprintDay sprintDayId;

    @ManyToOne()
    SprintDay sprintDay;
    Float remaining;
}
