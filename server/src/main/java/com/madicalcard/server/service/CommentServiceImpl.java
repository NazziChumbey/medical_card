package com.madicalcard.server.service;

import com.madicalcard.server.model.Comment;
import com.madicalcard.server.model.Patient;
import com.madicalcard.server.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public Comment create(Comment comment) {
        System.out.println(comment.toString());
        return repository.save(comment);
    }

    @Override
    public Comment delete(int id) {
        Comment comment = (Comment) findById(id);
        if (comment != null) {
            repository.delete(comment);
        }
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Comment findByIdAndPatientId(int id, int patientID) {
        return repository.findByIdAndPatient_Id(id, patientID);
    }

    @Override
    public List<Comment> findCommentByPatientId(int patientID) {
        return repository.findCommentByPatient_Id(patientID);
    }

    @Override
    public Comment update(Comment comment) {
        return repository.save(comment);
    }
}
