package com.gymplanner.gym_app.excercises.ports;
import com.gymplanner.gym_app.excercises.domain.Exercise;
import java.util.UUID;

public interface ExerciseRepository {
    Exercise save(Exercise exercise);
    Exercise findByName(String name);
    Exercise findById(String name);
    Exercise update(Exercise exercise);
    void deleteById(UUID id);
}
