package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CreateRoutineIntegrationTest {

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private CreateRoutine createRoutine;

    @Test
    void shouldCreateAndSaveRoutineInDatabase() {
        // Arrange
        CreateRoutineCommand cmd = new CreateRoutineCommand("Integration Test Routine", "Test Objective", "Beginner", List.of(), null);

        // Act
        Routine result = createRoutine.execute(cmd);

        // Assert
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("Integration Test Routine", result.getName());
        assertEquals("Test Objective", result.getObjective());

        // Verify persisted
        Routine persisted = routineRepository.findById(result.getId());
        assertNotNull(persisted);
        assertEquals(result.getId(), persisted.getId());
    }
}