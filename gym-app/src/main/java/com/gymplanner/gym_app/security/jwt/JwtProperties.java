package com.gymplanner.gym_app.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "security.jwt")
@Getter
@Setter
public class JwtProperties {

    /**
     * Secret used to sign JWT (HS256).
     * Debe venir de application.yml / env var.
     */
    private String secret;

    /**
     * Access token expiration in minutes.
     */
    private long expirationMinutes;
    
}