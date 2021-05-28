package com.madicalcard.server.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    private LocalDateTime dateOfWriting;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    public Comment(String comment, LocalDateTime dateOfWriting, Patient patient) {
        this.patient = patient;
        this.comment = comment;
        this.dateOfWriting = dateOfWriting;
    }

    public Comment() {

    }
}
