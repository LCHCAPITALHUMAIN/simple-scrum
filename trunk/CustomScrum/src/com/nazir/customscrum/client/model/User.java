package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.*;


@Entity
public class User extends DomainObject {
    @Id
    public String userUid;
    public String firstName;
    public String lastName;
    public String emailAddress;
}