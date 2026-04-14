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
}

//Las validaciones deben hacerse en la request
