package com.gymplanner.gym_app.routines.usecases;

import com.gymplanner.gym_app.routines.domain.Routine;
import com.gymplanner.gym_app.routines.ports.RoutineRepository;
import com.gymplanner.gym_app.users.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AssignRoutineToStudentTest {

    @Mock
    private RoutineRepository routineRepository;

    @InjectMocks
    private AssignRoutineToStudent assignRoutineToStudent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAssignRoutineToStudentSuccessfully() {
        // Arrange
        UUID routineId = UUID.randomUUID();
        UUID studentId = UUID.randomUUID();
        User student = new User(studentId, "Student Name", "student@example.com", "password", true);
        Routine baseRoutine = new Routine(routineId, "Base Routine", "Objective", "Level", List.of(), null, java.time.Instant.now());
        Routine assignedRoutine = new Routine(UUID.randomUUID(), "Base Routine", "Objective", "Level", List.of(), student, java.time.Instant.now());
        AssignRoutineCommand cmd = new AssignRoutineCommand(routineId, student);

        when(routineRepository.findById(routineId)).thenReturn(baseRoutine);
        when(routineRepository.save(any(Routine.class))).thenReturn(assignedRoutine);

        // Act
        Routine result = assignRoutineToStudent.execute(cmd);

        // Assert
        assertNotNull(result);
        assertEquals(student, result.getAssignedTo());
        assertNotEquals(routineId, result.getId()); // New ID for assigned routine
        verify(routineRepository).findById(routineId);
        verify(routineRepository).save(any(Routine.class));
    }
}