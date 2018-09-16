package com.jvdkolk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Simple super class that introduces the
 * id column from the database.. and an handy
 * isNew method
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractPersistable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isNew() {
        return id == null;
    }
}
