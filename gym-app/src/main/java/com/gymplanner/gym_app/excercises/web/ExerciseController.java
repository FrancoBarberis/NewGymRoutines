package com.gymplanner.gym_app.excercises.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gymplanner.gym_app.excercises.usecases.RegisterExercise;
import com.gymplanner.gym_app.excercises.web.requests.RegisterExerciseRequest;
import com.gymplanner.gym_app.excercises.web.responses.RegisterExerciseResponse;


@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    public RegisterExercise registerExercise;

    public ExerciseController(RegisterExercise registerExercise){
        this.registerExercise = registerExercise;
    }

    @PostMapping("/register")
    public RegisterExerciseResponse register(@RequestBody RegisterExerciseRequest request) {
        //PREAUTHORIZE CON ENTRENADOR O ADMIN
        //TODO: process POST request
        
        return new RegisterExerciseResponse("1", request.nombre(), request.descripcion());
    }
    

}
