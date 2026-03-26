package com.gymplanner.gym_app.users.domain;

import java.util.UUID;

import lombok.Data;

@Data
public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private boolean verified;

    public User(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.verified = false; //SIRVE PARA CONFIRMACION CON EMAIL
    }

}
