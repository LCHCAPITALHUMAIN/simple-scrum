package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.*;


@Entity
public abstract class User extends DomainObject {
    @Id
    private String userUid;
    private String firstName;
    private String lastName;
    private String emailAddress;
}