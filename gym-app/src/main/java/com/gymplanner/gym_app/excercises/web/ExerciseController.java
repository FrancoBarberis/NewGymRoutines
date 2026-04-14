package com.gymplanner.gym_app.excercises.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import java.util.UUID;

import com.gymplanner.gym_app.excercises.usecases.RegisterExercise;
import com.gymplanner.gym_app.excercises.usecases.RegisterExerciseCommand;
import com.gymplanner.gym_app.excercises.usecases.EditExerciseCommand;
import com.gymplanner.gym_app.excercises.web.requests.RegisterExerciseRequest;
import com.gymplanner.gym_app.excercises.web.responses.RegisterExerciseResponse;
import com.gymplanner.gym_app.excercises.domain.Exercise;
import com.gymplanner.gym_app.excercises.usecases.EditExercise;
import com.gymplanner.gym_app.excercises.web.requests.EditExerciseRequest;
import com.gymplanner.gym_app.excercises.web.responses.EditExerciseResponse;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final RegisterExercise registerExercise;
    private final EditExercise editExercise;

    public ExerciseController(RegisterExercise registerExercise, EditExercise editExercise) {
        this.registerExercise = registerExercise;
        this.editExercise = editExercise;
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
    public EditExerciseResponse edit(
            @PathVariable UUID id,
            @Valid @RequestBody EditExerciseRequest request) {
        EditExerciseCommand cmd = new EditExerciseCommand(
                id,
                request.nombre(),
                request.muscleGroup(),
                request.descripcion(),
                request.exerciseType());
        Exercise exercise = editExercise.execute(cmd);
        return new EditExerciseResponse(
                exercise.getId(),
                exercise.getName(),
                exercise.getMuscleGroup(),
                exercise.getDescription(),
                exercise.getExerciseType());
    }
}
