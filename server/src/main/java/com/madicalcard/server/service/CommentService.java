package com.madicalcard.server.service;

import com.madicalcard.server.model.Comment;


import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    Comment delete(int id);

    List<Comment> findAll();

    Comment findByIdAndPatientId(int id, int patientID);

    List<Comment> findCommentByPatientId(int patientID);

    Comment findById(int id);

    Comment update(Comment comment);

}