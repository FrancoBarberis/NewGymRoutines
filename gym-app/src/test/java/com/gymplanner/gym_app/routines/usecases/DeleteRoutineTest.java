package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

class DeleteRoutineTest {

    @Mock
    private RoutineRepository routineRepository;

    @InjectMocks
    private DeleteRoutine deleteRoutine;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeleteRoutineSuccessfully() {
        // Arrange
        UUID routineId = UUID.randomUUID();

        // Act
        deleteRoutine.execute(routineId);

        // Assert
        verify(routineRepository).deleteById(routineId);
    }
}