package com.jvdkolk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class User extends AbstractPersistable {

    private String password;

    private String username;
}
