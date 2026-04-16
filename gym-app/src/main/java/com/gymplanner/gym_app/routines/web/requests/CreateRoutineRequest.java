package com.gymplanner.gym_app.routines.web.requests;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.gymplanner.gym_app.routines.domain.ExerciseInRoutine;

public record CreateRoutineRequest(

    @NotBlank(message = "Falta el nombre de rutina")
    @Size(max = 100, min = 1, message = "El nombre de rutina debe tener entre 1 y 100 caracteres")
    String name,

    @NotBlank(message = "Falta el objetivo de la rutina")
    @Size(max = 255, message = "El máximo de caracteres es 255")
    String objective,

    @NotBlank(message = "Falta el nivel de la rutina")
    String level,

    @NotEmpty(message = "La rutina debe tener al menos un ejercicio")
    List<ExerciseInRoutine> exercises,

    // Opcional: solo si se asigna al crear
    UUID assignedToUserId
) {}
