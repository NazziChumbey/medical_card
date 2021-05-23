package com.madicalcard.server.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;



@Entity
@ToString
public class Comment {

    @Id
    @Setter @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter @Getter
    private String comment;

    @Setter @Getter
    private Date dateOfWriting;

    @ManyToOne
    @Setter
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Comment() {
    }

    public Comment(String comment, Date dateOfWriting, Patient patient) {
        this.patient = patient;
        this.comment = comment;
        this.dateOfWriting = dateOfWriting;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int idComment) {
//        this.id = id;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public Date getDateOfWriting() {
//        return dateOfWriting;
//    }
//
//    public void setDateOfWriting(Date dateOfWriting) {
//        this.dateOfWriting = dateOfWriting;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
//
//    @Override
//    public String toString() {
//        return "Comment{" +
//                "idComment=" + id +
//                ", comment='" + comment + '\'' +
//                ", dateOfWriting=" + dateOfWriting +
//                ", patient=" + patient +
//                '}';
//    }
}