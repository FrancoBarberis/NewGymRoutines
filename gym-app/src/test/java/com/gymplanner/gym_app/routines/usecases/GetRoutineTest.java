package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetRoutineTest {

    @Mock
    private RoutineRepository routineRepository;

    @InjectMocks
    private GetRoutine getRoutine;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetRoutineSuccessfully() {
        // Arrange
        UUID routineId = UUID.randomUUID();
        Routine routine = new Routine(routineId, "Test Routine", "Test Objective", "Intermediate", List.of(), null, java.time.Instant.now());

        when(routineRepository.findById(routineId)).thenReturn(routine);

        // Act
        Routine result = getRoutine.execute(routineId);

        // Assert
        assertNotNull(result);
        assertEquals(routineId, result.getId());
        assertEquals("Test Routine", result.getName());
        verify(routineRepository).findById(routineId);
    }

    @Test
    void shouldReturnNullWhenRoutineNotFound() {
        // Arrange
        UUID routineId = UUID.randomUUID();

        when(routineRepository.findById(routineId)).thenReturn(null);

        // Act
        Routine result = getRoutine.execute(routineId);

        // Assert
        assertNull(result);
        verify(routineRepository).findById(routineId);
    }
}