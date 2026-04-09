package com.gymplanner.gym_app.excercises.web.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;
import com.gymplanner.gym_app.excercises.domain.ExerciseType; 

public record RegisterExerciseRequest(

    @NotBlank(message = "Nombre es obligatorio")
    String nombre,

    @NotNull(message = "Grupo muscular es obligatorio")
    MuscleGroup muscleGroup,

    String descripcion,

    @NotNull(message = "Tipo de ejercicio es obligatorio")
    ExerciseType exerciseType
) {}