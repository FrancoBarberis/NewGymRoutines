package com.gymplanner.gym_app.excercises.usecases;

import com.gymplanner.gym_app.excercises.domain.Exercise;
import com.gymplanner.gym_app.excercises.domain.ExerciseType;
import com.gymplanner.gym_app.excercises.domain.MuscleGroup;
import com.gymplanner.gym_app.excercises.ports.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EditExerciseTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private EditExercise editExercise;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldEditExerciseSuccessfully() {
        // Arrange
        UUID exerciseId = UUID.randomUUID();
        EditExerciseCommand cmd = new EditExerciseCommand(exerciseId, "Updated Bench Press", MuscleGroup.PECHO, "Updated description", ExerciseType.FUERZA);
        Exercise updatedExercise = new Exercise(exerciseId, "Updated Bench Press", MuscleGroup.PECHO, "Updated description", ExerciseType.FUERZA);

        when(exerciseRepository.update(any(Exercise.class))).thenReturn(updatedExercise);

        // Act
        Exercise result = editExercise.execute(cmd);

        // Assert
        assertNotNull(result);
        assertEquals(exerciseId, result.getId());
        assertEquals("Updated Bench Press", result.getName());
        assertEquals("Updated description", result.getDescription());
        verify(exerciseRepository).update(any(Exercise.class));
    }
}