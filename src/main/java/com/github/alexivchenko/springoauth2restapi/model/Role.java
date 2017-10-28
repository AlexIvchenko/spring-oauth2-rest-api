package com.github.alexivchenko.springoauth2restapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Alex Ivchenko
 */
@Entity
@NoArgsConstructor
public @Data class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
