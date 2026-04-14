package com.gymplanner.gym_app.excercises.usecases;

import lombok.AllArgsConstructor;

import com.gymplanner.gym_app.excercises.domain.Exercise;
import com.gymplanner.gym_app.excercises.ports.ExerciseRepository;
import java.util.UUID;

@AllArgsConstructor
public class EditExercise {

    private final ExerciseRepository exerciseRepository;

    public Exercise execute(EditExerciseCommand cmd){
        Exercise exercise = new Exercise(
            UUID.randomUUID(),
            cmd.name(),
            cmd.muscleGroup(),
            cmd.description(),
            cmd.exerciseType());
        return exerciseRepository.update(exercise);
    }

}
