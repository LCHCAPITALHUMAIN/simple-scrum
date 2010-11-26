package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 07-May-2010
 * Time: 17:16:31
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Estimate extends DomainObject{
    @Id
    public int id;
    public Date estimatedDate;
    public EstimateType estimateType;
    public float estimate;
    @OneToMany
    public Set<User> doneBy;
    //TODO
//    public List<String> rationales;
    public String comments;
}
