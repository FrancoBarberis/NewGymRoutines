package com.gymplanner.gym_app.routines.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gymplanner.gym_app.routines.usecases.CopyRoutine;
import com.gymplanner.gym_app.routines.usecases.CreateRoutine;
import com.gymplanner.gym_app.routines.usecases.EditRoutine;
import com.gymplanner.gym_app.routines.web.requests.CreateRoutineRequest;

import lombok.AllArgsConstructor;

import com.gymplanner.gym_app.routines.domain.Routine;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/routines")
@AllArgsConstructor
public class RoutineController {
    
    private final CreateRoutine createRoutine;
    private final EditRoutine editRoutine;
    private final CopyRoutine copyRoutine;

    @PostMapping("/register")
    //Registra una rutina nueva para un estudiante
    public Routine register(@RequestBody CreateRoutineRequest request) {
        //TODO: process POST request
        
        return null;
    }

    @GetMapping("/{studentId}")
    //Devuelve las rutinas asignadas a un estudiante
    public List<Routine> getStudentRoutines(@PathVariable UUID studentId) {
        return List.of();
    }

    @PostMapping("/copy/{routineId}/")
    //Copia una rutina ya creada y la asigna a un estudiante
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    

}
