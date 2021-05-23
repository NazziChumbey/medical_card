package com.madicalcard.server.controller;

import com.madicalcard.server.model.Comment;
import com.madicalcard.server.model.Patient;
import com.madicalcard.server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"patients/{patientId}/comments"})
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment create(@RequestBody Comment comment, @PathVariable("patientId") String patientId){
        comment.setPatient(new Patient(patientId));
        comment.setDateOfWriting(new java.sql.Date(new Date().getTime()));
        return commentService.create(comment);
    }

    @GetMapping
    public List<Comment> findOne(@PathVariable("patientId") int patientId){
        return commentService.findCommentByPatient_Id(patientId);
    }

    @GetMapping(path = {"/{id}"})
    public Comment findCommentId(@PathVariable("id") int id, @PathVariable("patientId") int patientId){
        return commentService.findByIdAndPatient_Id(id, patientId);
    }

    @PutMapping(path = {"/{id}"})
    public Comment update(@PathVariable("id") int id, @RequestBody Comment comment){
        comment.setId(id);
        return commentService.update(comment);
    }

    @DeleteMapping(path ={"/{id}"})
    public Comment delete(@PathVariable("id") int id) {
        return commentService.delete(id);
    }

    @GetMapping(path ={"/all"})
    public List<Comment> findAll(){
        return commentService.findAll();
    }
}