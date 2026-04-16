package com.gymplanner.gym_app.routines.usecases;

import java.util.List;
import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListRoutines {
    private final RoutineRepository routineRepository;

    public List<Routine> execute() {
        return List.of();
    }
}
