package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import java.util.List;

import org.hibernate.validator.Range;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 11-May-2010
 * Time: 15:20:15
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Actual extends DomainObject{
    @EmbeddedId
    ActualKey id;
    
    @Range(min = 0, max = 1)
    Float daySpent;


}