package com.gymplanner.gym_app.excercises.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gymplanner.gym_app.excercises.usecases.EditExercise;
import com.gymplanner.gym_app.excercises.usecases.RegisterExercise;
import com.gymplanner.gym_app.excercises.ports.ExerciseRepository;

@Configuration
public class ExerciseConfig {

    @Bean
    RegisterExercise registerExercise(
        ExerciseRepository exerciseRepository
    ) {
        return new RegisterExercise(exerciseRepository);
    }

    @Bean
    EditExercise editExercise(
        ExerciseRepository exerciseRepository){
            return new EditExercise(exerciseRepository);
        }

}

