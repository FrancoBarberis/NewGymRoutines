package com.gymplanner.gym_app.excercises.usecases;

import java.util.UUID;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;
import com.gymplanner.gym_app.excercises.domain.ExerciseType;

public record EditExerciseCommand(
    UUID id,
    String name,
    MuscleGroup muscleGroup,
    String description,
    ExerciseType exerciseType
) {}
