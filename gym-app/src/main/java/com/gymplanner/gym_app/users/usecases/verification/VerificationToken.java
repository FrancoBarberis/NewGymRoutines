package com.gymplanner.gym_app.users.usecases.verification;

import java.util.UUID;

public class VerificationToken {
    private final String token;
    private final UUID userId;

    public VerificationToken(String token, UUID userId) {
        this.token = token;
        this.userId = userId;
    }

    public String token() {
        return token;
    }

    public UUID userId() {
        return userId;
    }
}