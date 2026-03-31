package com.gymplanner.gym_app.users.authentication;

public record AuthenticateUserCommand(
    String email,
    String password
) {}