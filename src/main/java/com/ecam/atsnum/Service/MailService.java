package com.ecam.atsnum.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.ecam.atsnum.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public void sendCredentials(String mailTo, String password) {
        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailFrom);
            helper.setTo(mailTo);
            helper.setSubject("Compte CTAWebApp créé !");
            message.setContent(generateHTML(mailTo, password), "text/html; charset=utf-8");
            emailSender.send(message);
        } catch (MessagingException me) {
        }
    }

    public static String generateHTML(String email, String password) {
        String content = "<h1>Vos identifiants à la plateforme CTAWebApp</h1>" +
                "<br>"
                + "<h2>Email : " + email + " </h2>" + "<br>"
                + "<h2>Password : " + password + " </h2>" + "<br>";
        return content;
    }

}
