package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.users.domain.User;
import java.util.UUID;

public record AssignRoutineCommand(
    UUID routineId,
    User student
) {}
