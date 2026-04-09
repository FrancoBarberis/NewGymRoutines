package com.gymplanner.gym_app.excercises.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymplanner.gym_app.excercises.infrastructure.jpa.entities.ExerciseEntity;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataExerciseRepository extends JpaRepository <ExerciseEntity, UUID> {

    Optional<ExerciseEntity> findByName(String name);

}
