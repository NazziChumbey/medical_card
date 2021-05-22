package com.madicalcard.server.repository;

import com.madicalcard.server.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    void delete(Patient patient);

    List<Patient> findAll();

    Patient findById(int id);

    List<Patient> findAllByFirstNameOrLastName(String firstname, String lastname);

    Patient save(Patient patient);
}
