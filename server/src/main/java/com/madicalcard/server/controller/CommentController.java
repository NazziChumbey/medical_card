package com.madicalcard.server.controller;

import com.madicalcard.server.model.Comment;
import com.madicalcard.server.model.Patient;
import com.madicalcard.server.service.CommentService;
import com.madicalcard.server.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"patients/{patientId}/comments"})
public class CommentController {
    public static List<Comment> commentsForEmailing = new ArrayList<Comment>();

    @Autowired
    private CommentService commentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    public JavaMailSender emailSender;

    @PostMapping
    public Comment create(@RequestBody Comment comment, @PathVariable("patientId") int patientId){
        comment.setPatient(new Patient(patientId));
        comment.setDateOfWriting(LocalDateTime.now());
        commentsForEmailing.add(comment);

        return commentService.create(comment);
    }

    @GetMapping
    public List<Comment> findOne(@PathVariable("patientId") int patientId){
        return commentService.findCommentByPatientId(patientId);
    }

    @GetMapping(path = {"/{id}"})
    public Comment findByID(@PathVariable("id") int id, @PathVariable("patientId") int patientId){
        return commentService.findByIdAndPatientId(id, patientId);
    }

    @PutMapping(path = {"/{id}"})
    public Comment update(@PathVariable("id") int id, @RequestBody Comment comment){
        comment.setId(id);
        return commentService.update(comment);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") int id) {
        commentService.delete(id);
    }

    @GetMapping(path ={"/all"})
    public List<Comment> findAll(){
        return commentService.findAll();
    }
}