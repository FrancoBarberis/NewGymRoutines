package com.gymplanner.gym_app.users.infrastructure.jpa;

import org.springframework.stereotype.Repository;
import com.gymplanner.gym_app.users.ports.VerificationTokenRepository;
import com.gymplanner.gym_app.users.usecases.verification.VerificationToken;
import com.gymplanner.gym_app.users.infrastructure.jpa.entities.VerificationTokenEntity;

@Repository
public class JpaVerificationTokenRepository implements VerificationTokenRepository {

    private final SpringDataVerificationTokenRepository repo;

    public JpaVerificationTokenRepository(SpringDataVerificationTokenRepository repo) {
        this.repo = repo;
    }

    @Override
    public void save(VerificationToken token) {
        repo.save(new VerificationTokenEntity(token.token(), token.userId()));
    }

    @Override
    public VerificationToken findByToken(String token) {
        return repo.findById(token)
                .map(e -> new VerificationToken(e.getToken(), e.getUserId()))
                .orElse(null);
    }
}