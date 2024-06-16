package com.booted.springy.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public String sendMail(String to,String subject, String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("tamanigabriel0@gmail.com");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        return "Email sent successfully";
    }
}
