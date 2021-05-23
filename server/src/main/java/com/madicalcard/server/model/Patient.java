package com.madicalcard.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@ToString
public class Patient {
    @Id
    @Setter @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter @Getter
    private String firstName;

    @Setter @Getter
    private String lastName;

    @Setter @Getter
    private Date dateOfBirth;

    @Setter @Getter
    private String sex;

    @Setter @Getter
    private String country;

    @Setter @Getter
    private String state;

    @Setter @Getter
    private String address;

    @OneToMany(mappedBy = "patient")
    private Collection<Comment> comments;

    public Patient() {
    }

    public Patient(String id) {
        this.id = Integer.parseInt(id);
    }

    public Patient(String firstName, String lastName, Date dateOfBirth, String sex, String country, String state, String address, Comment comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.country = country;
        this.state = state;
        this.address = address;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
/*
    public Collection<Comment> getComments() {
        return this.comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
*/
//    @Override
//    public String toString() {
//        return "Patient{" +
//                "idPatient=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
//                ", sex='" + sex + '\'' +
//                ", country='" + country + '\'' +
//                ", state='" + state + '\'' +
//                ", address='" + address + '\'' +
//                ", commentSet=" + comments +
//                '}';
//    }
}
