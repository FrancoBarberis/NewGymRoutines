package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateRoutineTest {

    @Mock
    private RoutineRepository routineRepository;

    @InjectMocks
    private CreateRoutine createRoutine;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateRoutineSuccessfully() {
        // Arrange
        CreateRoutineCommand cmd = new CreateRoutineCommand("Morning Workout", "Build strength", "Beginner", List.of(), null);
        Routine savedRoutine = new Routine(java.util.UUID.randomUUID(), "Morning Workout", "Build strength", "Beginner", List.of(), null, java.time.Instant.now());

        when(routineRepository.save(any(Routine.class))).thenReturn(savedRoutine);

        // Act
        Routine result = createRoutine.execute(cmd);

        // Assert
        assertNotNull(result);
        assertEquals("Morning Workout", result.getName());
        assertEquals("Build strength", result.getObjective());
        verify(routineRepository).save(any(Routine.class));
    }
}