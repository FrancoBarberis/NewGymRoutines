package com.gymplanner.gym_app.excercises.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Exercise {
    private UUID id;
    private String name;
    private MuscleGroup muscleGroup;
    private String description;
    private ExerciseType exerciseType;
}
