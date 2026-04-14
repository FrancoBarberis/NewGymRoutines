package com.gymplanner.gym_app.excercises.web.responses;

import java.util.UUID;

import com.gymplanner.gym_app.excercises.domain.ExerciseType;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;

public record EditExerciseResponse(UUID id, String nombre, MuscleGroup muscleGroup, String descripcion, ExerciseType exerciseType) {
}