package com.gymplanner.gym_app.users.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gymplanner.gym_app.users.infrastructure.jpa.entities.VerificationTokenEntity;

public interface SpringDataVerificationTokenRepository
        extends JpaRepository<VerificationTokenEntity, String> {
}