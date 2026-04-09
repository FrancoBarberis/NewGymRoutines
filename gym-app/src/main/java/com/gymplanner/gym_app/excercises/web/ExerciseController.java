package com.gymplanner.gym_app.excercises.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import com.gymplanner.gym_app.excercises.usecases.RegisterExercise;
import com.gymplanner.gym_app.excercises.usecases.RegisterExerciseCommand;
import com.gymplanner.gym_app.excercises.web.requests.RegisterExerciseRequest;
import com.gymplanner.gym_app.excercises.web.responses.RegisterExerciseResponse;
import com.gymplanner.gym_app.excercises.domain.Exercise;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final RegisterExercise registerExercise;
    private final EditExercise editExercise;

    public ExerciseController(RegisterExercise registerExercise) {
        this.registerExercise = registerExercise;
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TRAINER')")
    public RegisterExerciseResponse register(
            @Valid @RequestBody RegisterExerciseRequest request) {
        RegisterExerciseCommand cmd = new RegisterExerciseCommand(
                request.nombre(),
                request.muscleGroup(),
                request.descripcion(),
                request.exerciseType());
        Exercise exercise = registerExercise.execute(cmd);
        return new RegisterExerciseResponse(
                exercise.getId(),
                exercise.getName(),
                exercise.getMuscleGroup(),
                exercise.getDescription(),
                exercise.getExerciseType());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TRAINER')")
    public RegisterExerciseResponse edit(
            @PathVariable String id,
            @Valid @RequestBody RegisterExerciseRequest request) {
        return registerExercise.update(id, request);
    }
}
