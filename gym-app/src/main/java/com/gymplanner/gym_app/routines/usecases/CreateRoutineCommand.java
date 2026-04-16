package com.gymplanner.gym_app.routines.usecases;

import java.util.List;
import java.util.UUID;
import com.gymplanner.gym_app.routines.domain.ExerciseInRoutine;

public record CreateRoutineCommand(
    String name,
    String objective,
    String level,
    List<ExerciseInRoutine> exercises,
    UUID assignedToUserId
) {
}
