package com.gymplanner.gym_app.users.infrastructure.email;

//TODO: IMPLEMENTAR LA LIBRERIA O DEPENDENCIA CORRECTA

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.gymplanner.gym_app.users.ports.EmailService;

@Service
public class SmtpEmailService implements EmailService {

    private final JavaMailSender mailSender;

    public SmtpEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendVerificationEmail(String to, String token) {
        String link = "http://localhost:8080/users/confirm?token=" + token;

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("Confirma tu cuenta");
        msg.setText("Hacé clic en el siguiente enlace:\n\n" + link);

        mailSender.send(msg);
    }
}