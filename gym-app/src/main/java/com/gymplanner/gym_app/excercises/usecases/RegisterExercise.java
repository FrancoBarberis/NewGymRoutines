package com.gymplanner.gym_app.excercises.usecases;

import com.gymplanner.gym_app.excercises.domain.Exercise;
import com.gymplanner.gym_app.excercises.ports.ExerciseRepository;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class RegisterExercise {

    private final ExerciseRepository exerciseRepository;

    public Exercise execute(RegisterExerciseCommand cmd){
        Exercise exercise = new Exercise(
            UUID.randomUUID(),
            cmd.name(),
            cmd.muscleGroup(),
            cmd.description(),
            cmd.exerciseType());
        return exerciseRepository.save(exercise);
    }

}
