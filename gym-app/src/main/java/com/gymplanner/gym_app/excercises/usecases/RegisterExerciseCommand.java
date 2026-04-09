package com.gymplanner.gym_app.excercises.usecases;

import com.gymplanner.gym_app.excercises.domain.ExerciseType;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;

public record RegisterExerciseCommand(
    String name,
    MuscleGroup muscleGroup,
    String description,
    ExerciseType exerciseType
) {}
