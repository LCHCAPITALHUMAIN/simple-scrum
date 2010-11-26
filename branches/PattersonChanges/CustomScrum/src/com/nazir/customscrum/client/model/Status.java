package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Status extends DomainObject {
    @Id
    private int id;
    private String name;
}
