package com.gymplanner.gym_app.routines.ports;

import com.gymplanner.gym_app.routines.domain.Routine;
import java.util.UUID;

public interface RoutineRepository {
    Routine save(Routine routine);
    Routine findByName(String name);
    Routine findById(UUID id);
    Routine update(Routine routine);
    void deleteById(UUID id);
}
