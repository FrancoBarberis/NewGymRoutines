package com.gymplanner.gym_app.excercises.usecases;

import com.gymplanner.gym_app.excercises.domain.Exercise;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;
import com.gymplanner.gym_app.excercises.domain.ExerciseType;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class RegisterExercise {

    public Exercise execute(){
        return new Exercise(UUID.randomUUID(),"Press banca", MuscleGroup.PECHO, "Se empuja una barra hacia arriba, acostado", ExerciseType.FUERZA);
    }

}
