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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RegisterExerciseTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private RegisterExercise registerExercise;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldRegisterExerciseSuccessfully() {
        // Arrange
        RegisterExerciseCommand cmd = new RegisterExerciseCommand("Bench Press", MuscleGroup.PECHO, "A classic chest exercise", ExerciseType.FUERZA);
        Exercise savedExercise = new Exercise(java.util.UUID.randomUUID(), "Bench Press", MuscleGroup.PECHO, "A classic chest exercise", ExerciseType.FUERZA);

        when(exerciseRepository.save(any(Exercise.class))).thenReturn(savedExercise);

        // Act
        Exercise result = registerExercise.execute(cmd);

        // Assert
        assertNotNull(result);
        assertEquals("Bench Press", result.getName());
        assertEquals(MuscleGroup.PECHO, result.getMuscleGroup());
        assertEquals(ExerciseType.FUERZA, result.getExerciseType());
        verify(exerciseRepository).save(any(Exercise.class));
    }
}