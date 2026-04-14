package com.gymplanner.gym_app.routines.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ExerciseInRoutine {
    private UUID id;
    private UUID routineId;
    private UUID exerciseId;
    private int series;
    private int repetitions;
    private int order;
}
