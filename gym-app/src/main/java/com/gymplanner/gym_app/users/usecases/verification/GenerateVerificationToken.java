package com.gymplanner.gym_app.users.usecases.verification;

import java.util.UUID;
import com.gymplanner.gym_app.users.ports.VerificationTokenRepository;

public class GenerateVerificationToken {

    private final VerificationTokenRepository repo;

    public GenerateVerificationToken(VerificationTokenRepository repo) {
        this.repo = repo;
    }

    public String create(UUID userId) {
        String token = UUID.randomUUID().toString();
        repo.save(new VerificationToken(token, userId));
        return token;
    }
}