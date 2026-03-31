package com.gymplanner.gym_app.users.web.requests;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticateUserRequest(
    @Email
    @NotBlank
    String email,

    @NotBlank
    String password
) {}