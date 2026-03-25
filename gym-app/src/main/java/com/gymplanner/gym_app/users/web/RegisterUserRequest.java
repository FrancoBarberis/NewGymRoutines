package com.gymplanner.gym_app.users.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequest(
    @NotBlank(message = "Nombre es obligatorio") String nombre, 
    @NotBlank(message = "Email es obligatorio") @Email(message = "Formato de email inválido") String email, 
    @NotBlank(message = "Password es obligatoria") String password
) {}