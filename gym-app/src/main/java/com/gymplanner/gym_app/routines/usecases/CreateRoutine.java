package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import com.gymplanner.gym_app.routines.web.requests.CreateRoutineRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateRoutine {

    private final RoutineRepository routineRepository;

    public Routine execute(CreateRoutineCommand cmd) {
        Routine routine = new Routine(cmd.name(), cmd.objective());
        return routineRepository.save(routine);
    }
}

