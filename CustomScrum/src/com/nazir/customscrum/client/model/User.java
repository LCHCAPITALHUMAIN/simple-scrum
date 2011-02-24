package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;
import org.hibernate.validator.NotNull;

import javax.persistence.*;


@Entity
public class User extends DomainObject {
    @Id
    public String userUid;
    @NotNull
    public String firstName;
    @NotNull
    public String lastName;
    @NotNull
    public String emailAddress;
    @OneToOne
    @NotNull
    public Profile profile;
}