package com.madicalcard.server.repository;

import com.madicalcard.server.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    void delete(Comment comment);

    List<Comment> findAll();

    Comment findByIdAndPatient_Id(int id, int patientID);

    List<Comment> findCommentByPatient_Id(int patientID);

    Comment findById(int id);

    Comment save(Comment comment);
}
