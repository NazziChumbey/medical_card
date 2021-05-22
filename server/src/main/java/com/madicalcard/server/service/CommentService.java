package com.madicalcard.server.service;

import com.madicalcard.server.model.Comment;
import org.springframework.stereotype.Service;


import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    Comment delete(int id);

    List<Comment> findAll();

    Comment findByIdAndPatient_Id(int id, int patientID);

    List<Comment> findCommentByPatient_Id(int patientID);

    Comment findById(int id);

    Comment update(Comment comment);

}