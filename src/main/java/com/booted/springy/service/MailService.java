package com.booted.springy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to,String subject, String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("tamanigabriel0@gmail.com");
    }
}
