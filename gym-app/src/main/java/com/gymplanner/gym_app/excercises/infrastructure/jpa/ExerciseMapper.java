package com.gymplanner.gym_app.excercises.infrastructure.jpa;

import com.gymplanner.gym_app.excercises.domain.Exercise;
import com.gymplanner.gym_app.excercises.infrastructure.jpa.entities.ExerciseEntity;

public class ExerciseMapper {

    public ExerciseEntity toEntity(Exercise exercise){
        return new ExerciseEntity(
            exercise.getId(),
            exercise.getName(),
            exercise.getMuscleGroup(),
            exercise.getExerciseType(),
            exercise.getDescription()
        );
    }

    public Exercise toDomain(ExerciseEntity exerciseEntity){
        return new Exercise(
            exerciseEntity.getId(),
            exerciseEntity.getNombre(),
            exerciseEntity.getMainMuscleGroup(),
            exerciseEntity.getDescription(),
            exerciseEntity.getExerciseType()
        );
    }
}
