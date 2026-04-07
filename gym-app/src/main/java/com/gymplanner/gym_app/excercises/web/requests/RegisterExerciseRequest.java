package com.gymplanner.gym_app.excercises.web.requests;

import jakarta.validation.constraints.NotBlank;

public record RegisterExerciseRequest(

    @NotBlank(message = "Nombre es obligatorio")
    String nombre,

    String descripcion
) {
}