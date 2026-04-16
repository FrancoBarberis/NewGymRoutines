package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateRoutine {
    private final RoutineRepository routineRepository;

    public Routine execute(Routine routine) {
        return routineRepository.update(routine);
    }
}
