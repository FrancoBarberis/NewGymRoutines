package com.gymplanner.gym_app.users.usecases;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.UserRepository;

public class RegisterUserTest {

    @Test
    void shouldRegisterUserSuccessfully() {
        // Arrange: crear mocks del repo y el encoder
        UserRepository repo = mock(UserRepository.class);
        PasswordEncoder encoder = mock(PasswordEncoder.class);

        RegisterUser useCase = new RegisterUser(repo, encoder);

        RegisterUserCommand cmd = new RegisterUserCommand(
            "Franco",
            "franco@mail.com",
            "1234"
        );

        // mock behavior
        when(repo.findByEmail("franco@mail.com")).thenReturn(null);
        when(encoder.encode("1234")).thenReturn("hashed1234");

        // Act
        User result = useCase.execute(cmd);

        // Assert
        assertNotNull(result);
        assertEquals("Franco", result.getNombre());
        assertEquals("franco@mail.com", result.getEmail());
        assertEquals("hashed1234", result.getPassword());

        // verify interactions
        verify(repo).findByEmail("franco@mail.com");
        verify(encoder).encode("1234");
        verify(repo).save(result);
    }

    @Test
    void shouldThrowWhenEmailIsAlreadyTaken() {
        // Arrange
        UserRepository repo = mock(UserRepository.class);
        PasswordEncoder encoder = mock(PasswordEncoder.class);

        RegisterUser useCase = new RegisterUser(repo, encoder);

        RegisterUserCommand cmd = new RegisterUserCommand(
            "Franco",
            "franco@mail.com",
            "1234"
        );

        // Mock: ya existe en la BD
        when(repo.findByEmail("franco@mail.com"))
                .thenReturn(new User(UUID.randomUUID(), "Franco", "franco@mail.com", "hash"));

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> useCase.execute(cmd));

        verify(repo).findByEmail("franco@mail.com");
        verify(repo, never()).save(any());
    }
}