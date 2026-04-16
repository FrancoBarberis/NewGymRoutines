package com.gymplanner.gym_app.routines.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gymplanner.gym_app.routines.usecases.*;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;

@Configuration
public class RoutineConfig {

    @Bean
    public CreateRoutine createRoutineUseCase(RoutineRepository routineRepository) {
        return new CreateRoutine(routineRepository);
    }

    @Bean
    public GetRoutine getRoutineUseCase(RoutineRepository routineRepository) {
        return new GetRoutine(routineRepository);
    }

    @Bean
    public UpdateRoutine updateRoutineUseCase(RoutineRepository routineRepository) {
        return new UpdateRoutine(routineRepository);
    }

    @Bean
    public DeleteRoutine deleteRoutineUseCase(RoutineRepository routineRepository) {
        return new DeleteRoutine(routineRepository);
    }

    @Bean
    public ListRoutines listRoutinesUseCase(RoutineRepository routineRepository) {
        return new ListRoutines(routineRepository);
    }
}
