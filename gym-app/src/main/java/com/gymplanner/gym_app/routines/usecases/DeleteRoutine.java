package com.gymplanner.gym_app.routines.usecases;

import java.util.UUID;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteRoutine {
    private final RoutineRepository routineRepository;

    public void execute(UUID routineId) {
        routineRepository.deleteById(routineId);
    }
}
