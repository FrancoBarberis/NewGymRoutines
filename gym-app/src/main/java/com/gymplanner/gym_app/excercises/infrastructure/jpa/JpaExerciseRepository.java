package com.gymplanner.gym_app.excercises.infrastructure.jpa;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.gymplanner.gym_app.excercises.domain.Exercise;
import com.gymplanner.gym_app.excercises.infrastructure.jpa.entities.ExerciseEntity;
import com.gymplanner.gym_app.excercises.ports.ExerciseRepository;
import com.gymplanner.gym_app.excercises.infrastructure.jpa.SpringDataExerciseRepository;

@Repository
public class JpaExerciseRepository implements ExerciseRepository {

    private final SpringDataExerciseRepository repo;
    private final ExerciseMapper mapper = new ExerciseMapper();

    public JpaExerciseRepository(SpringDAtaExerciseRepository repo){
        this.repo = repo;
    }

    @Override
    public Exercise save(Exercise exercise) {
        ExerciseEntity entity = mapper.toEntity(exercise);
        ExerciseEntity saved = repo.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Exercise findByName(String name) {
        return repo.findByName(name)
        .map(mapper::toDomain)
        .orElse(null);
    }

    @Override
    public Exercise findById(UUID id) {
        return repo.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public Exercise update(Exercise exercise) {
        return save(exercise);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}
