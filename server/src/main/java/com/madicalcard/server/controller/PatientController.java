package com.madicalcard.server.controller;


import com.madicalcard.server.model.Comment;
import com.madicalcard.server.model.Patient;
import com.madicalcard.server.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/patients"})
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient create(@RequestBody Patient patient){
        return patientService.create(patient);
    }

    @GetMapping(path = {"/{id}"})
    public Patient findOne(@PathVariable("id") int id){
        return patientService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Patient update(@PathVariable("id") int id, @RequestBody Patient patient){
        patient.setId(id);
        return patientService.update(patient);
    }

    @GetMapping(path = {"/find/{name}"})
    public List<Patient> findAllByFirstOrLastName(@PathVariable("name") String name){
        return patientService.findAllByFirstNameOrLastName(name, name);
    }

    @DeleteMapping(path ={"/{id}"})
    public Patient delete(@PathVariable("id") int id) {
        return patientService.delete(id);
    }

    @GetMapping
    public List<Patient> findAll(){
        return patientService.findAll();
    }
}