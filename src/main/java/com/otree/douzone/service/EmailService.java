package com.otree.douzone.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public int sendEmail(String email) {
        int min = 10000;
        int max = 99999;
        int randomNumber = (int) (Math.random() * (max - min + 1) + min);
        String text = "인증 번호: " + randomNumber;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("회원가입을 위한 인증번호입니다.");
        message.setText(text);
        mailSender.send(message);

        return randomNumber;
    }
}
