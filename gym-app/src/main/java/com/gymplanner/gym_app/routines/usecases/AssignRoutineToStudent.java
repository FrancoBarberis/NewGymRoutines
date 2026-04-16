package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AssignRoutineToStudent {

    private final RoutineRepository routineRepository;

    public Routine execute(AssignRoutineCommand cmd) {
        Routine baseRoutine = routineRepository.findById(cmd.routineId());
        Routine assignedRoutine = baseRoutine.cloneForStudent(cmd.student());
        return routineRepository.save(assignedRoutine);
    }

}
