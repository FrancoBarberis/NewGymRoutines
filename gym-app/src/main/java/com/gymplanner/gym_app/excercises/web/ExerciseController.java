package com.gymplanner.gym_app.excercises.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.gymplanner.gym_app.excercises.web.requests.RegisterExerciseRequest;
import com.gymplanner.gym_app.excercises.web.responses.RegisterExerciseResponse;


@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    public ExerciseController(){

    }

    @PostMapping("/register")
    public RegisterExerciseResponse register(@RequestBody RegisterExerciseRequest request) {
        //TODO: process POST request
        
        return new RegisterExerciseResponse("1", request.nombre(), request.descripcion());
    }
    

}
