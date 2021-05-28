package com.madicalcard.server.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String sex;

    private String country;

    private String state;

    private String address;

    private String email;

    @OneToMany(mappedBy = "patient")
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    private Collection<Comment> comments;

    public Patient() {}

    public Patient(int id) {
        this.id = id;
    }
}
