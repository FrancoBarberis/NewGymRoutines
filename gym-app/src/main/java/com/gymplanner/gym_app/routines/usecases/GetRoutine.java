package com.gymplanner.gym_app.routines.usecases;

import java.util.UUID;
import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetRoutine {
    private final RoutineRepository routineRepository;

    public Routine execute(UUID routineId) {
        return routineRepository.findById(routineId);
    }
}
