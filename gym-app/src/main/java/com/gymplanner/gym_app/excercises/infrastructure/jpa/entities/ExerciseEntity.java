package com.gymplanner.gym_app.excercises.infrastructure.jpa.entities;

import java.util.UUID;

import com.gymplanner.gym_app.excercises.domain.ExerciseType;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "exercises")
public class ExerciseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private MuscleGroup mainMuscleGroup;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    private String description;

    protected ExerciseEntity() {
    }
    
}