package com.gymplanner.gym_app.routines.domain;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.gymplanner.gym_app.users.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Routine {
    private UUID id;
    private String name;
    private String objective;
    private String level;
    private List<ExerciseInRoutine> exerciseList;
    private User assignedTo;
    private Instant createdAt;

    public Routine(String name, String objective) {
        this(UUID.randomUUID(), name, objective, null, null, null, Instant.now());
    }

    public Routine cloneForStudent(User student) {
        return new Routine(UUID.randomUUID(), this.name, this.objective, this.level, this.exerciseList, student, Instant.now());
    }
}

//Las validaciones deben hacerse en la request
