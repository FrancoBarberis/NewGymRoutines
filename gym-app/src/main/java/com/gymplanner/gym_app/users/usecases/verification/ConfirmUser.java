package com.gymplanner.gym_app.users.usecases.verification;

import com.gymplanner.gym_app.users.ports.UserRepository;
import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.VerificationTokenRepository;

public class ConfirmUser {

    private final VerificationTokenRepository tokenRepo;
    private final UserRepository userRepo;

    public ConfirmUser(VerificationTokenRepository tokenRepo, UserRepository userRepo) {
        this.tokenRepo = tokenRepo;
        this.userRepo = userRepo;
    }

    public void execute(String token) {
        var stored = tokenRepo.findByToken(token);
        if (stored == null) {
            throw new IllegalArgumentException("Token inválido o expirado");
        }

        User user = userRepo.findById(stored.userId());
        if (user == null) {
            throw new IllegalStateException("Usuario no encontrado");
        }

        user.setVerified(true);
        userRepo.update(user);
    }
}