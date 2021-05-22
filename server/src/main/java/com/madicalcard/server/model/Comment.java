package com.madicalcard.server.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.DateTimeException;


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    private Date dateOfWriting;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


    public Comment() {
    }

    public Comment(String comment, Date dateOfWriting, Patient patient) {
        this.patient = patient;
        this.comment = comment;
        this.dateOfWriting = dateOfWriting;
    }

    public int getIdComment() {
        return id;
    }

    public void setIdComment(int idComment) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(Date dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + id +
                ", comment='" + comment + '\'' +
                ", dateOfWriting=" + dateOfWriting +
                ", patient=" + patient +
                '}';
    }
}