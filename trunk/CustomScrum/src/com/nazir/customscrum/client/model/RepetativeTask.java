package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.NotNull;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02-Jun-2010
 * Time: 19:03:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class RepetativeTask extends DomainObject{
    @Id
    private long id;
    public TaskType taskType;
    @NotNull
    public String title;
    public String description;
    String remark;
}