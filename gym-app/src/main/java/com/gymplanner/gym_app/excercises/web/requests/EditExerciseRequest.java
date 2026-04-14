package com.gymplanner.gym_app.excercises.web.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;
import com.gymplanner.gym_app.excercises.domain.ExerciseType;
import jakarta.validation.constraints.Size; 

public record EditExerciseRequest(

    @NotBlank(message = "Nombre es obligatorio")
    @Size(min = 3, max = 100, message = "Nombre debe tener entre 3 y 100 caracteres")
    String nombre,

    @NotNull(message = "Grupo muscular es obligatorio")
    MuscleGroup muscleGroup,

    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    String descripcion,

    @NotNull(message = "Tipo de ejercicio es obligatorio")
    ExerciseType exerciseType
) {}