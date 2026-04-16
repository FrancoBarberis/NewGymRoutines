package com.gymplanner.gym_app.users.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private boolean verified;

    public User(UUID id, String name, String email, String password) {
        this(id, name, email, password, false);
    }
}
