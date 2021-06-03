package com.madicalcard.server.schedulers;

import com.madicalcard.server.controller.CommentController;
import com.madicalcard.server.model.Comment;
import com.madicalcard.server.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

@Component
public class SchedulerMail {
    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    CommentController commentController;

    @Autowired
    private PatientService patientService;



    //    @Scheduled(cron = "40-50 * * * *") // Формат:  секунда, минута, час, день, месяц, день недели
    @Scheduled(fixedDelay = 50000)
    public String sendSimpleEmail() {
        if(CommentController.commentsForEmailing.isEmpty()){
            System.out.println("----------");
        } else {
            System.out.println("++++++++++");
        }
//        comments.forEach(comment -> {
//            System.out.println("++++++++++"+patientService.findById(comment.getPatient().getId()).getEmail());
//            String date = comment.getDateOfWriting().format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
//
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(patientService.findById(comment.getPatient().getId()).getEmail());
//            message.setSubject("Додано новий коментар! " + date);
//            message.setText(comment + "\n " + date);
//
//            this.emailSender.send(message);
//        });
        return "Email Sent!";
    }
}
