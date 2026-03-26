package com.gymplanner.gym_app.users.ports;

import com.gymplanner.gym_app.users.usecases.verification.VerificationToken;

public interface VerificationTokenRepository {
    void save(VerificationToken token);
    VerificationToken findByToken(String token);
}