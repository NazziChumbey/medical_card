package com.madicalcard.server.service;

import com.madicalcard.server.model.Comment;
import com.madicalcard.server.model.Patient;
import com.madicalcard.server.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public Patient create(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient delete(int id) {
        Patient patient = findById(id);
        if(patient != null){
            repository.delete(patient);
        }
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    public Patient findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Patient> findAllByFirstNameOrLastName(String firstname, String lastname) {
        return repository.findAllByFirstNameOrLastName(firstname, lastname);
    }

    @Override
    public Patient update(Patient patient) {
        return repository.save(patient);
    }
}
