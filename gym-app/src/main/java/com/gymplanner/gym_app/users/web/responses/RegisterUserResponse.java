package com.gymplanner.gym_app.users.web.responses;

import com.gymplanner.gym_app.users.domain.User;

public record RegisterUserResponse(String id, String nombre, String email) {

    public static RegisterUserResponse from(User user) {
        return new RegisterUserResponse(
            user.getId().toString(),
            user.getName(),
            user.getEmail()
        );
    }
}