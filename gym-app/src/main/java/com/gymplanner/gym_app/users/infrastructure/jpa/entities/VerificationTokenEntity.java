package com.gymplanner.gym_app.users.infrastructure.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "verification_tokens")
@Getter
public class VerificationTokenEntity {

    @Id
    private String token;

    @Column(nullable = false)
    private UUID userId;

    protected VerificationTokenEntity() {}

    public VerificationTokenEntity(String token, UUID userId) {
        this.token = token;
        this.userId = userId;
    }
}