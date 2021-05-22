package com.madicalcard.server.service;

import com.madicalcard.server.model.Comment;
import com.madicalcard.server.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {

    Patient create(Patient patient);

    Patient delete(int id);

    List<Patient> findAll();

    Patient findById(int id);

    List<Patient> findAllByFirstNameOrLastName(String firstname, String lastname);

    Patient update(Patient patient);
}
