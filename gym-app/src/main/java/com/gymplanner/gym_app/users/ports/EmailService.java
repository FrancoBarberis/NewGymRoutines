package com.gymplanner.gym_app.users.ports;

public interface EmailService {
    void sendVerificationEmail(String to, String token);
}