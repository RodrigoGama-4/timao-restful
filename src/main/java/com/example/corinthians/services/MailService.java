package com.example.corinthians.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.corinthians.dtos.RegisterDTO;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;


    @Value("${spring.mail.username}")
    private String fromMail;

    public String senderMail(RegisterDTO data){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject("CADASTRO NA NOSSA API :)");
        simpleMailMessage.setText("Seja bem vindo a nossa aplicação. Espero que você tenha uma ótima experiência.");
        simpleMailMessage.setTo(data.email());


        return "Email enviado com sucesso";
    }
}
