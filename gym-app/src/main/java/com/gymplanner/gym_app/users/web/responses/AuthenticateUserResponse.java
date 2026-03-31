package com.gymplanner.gym_app.users.web.responses;
import com.gymplanner.gym_app.users.domain.User;

public record AuthenticateUserResponse(
    String id,
    String nombre,
    String email
) {
    public static AuthenticateUserResponse from(User user) {
        return new AuthenticateUserResponse(
            user.getId().toString(),
            user.getName(),
            user.getEmail()
        );
    }
}