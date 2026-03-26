package com.gymplanner.gym_app.users.usecases;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.UserRepository;
import com.gymplanner.gym_app.users.ports.EmailService;
import com.gymplanner.gym_app.users.usecases.verification.GenerateVerificationToken;

public class RegisterUserTest {

    @Test
    void shouldRegisterUserSuccessfully() {
        // Arrange: crear mocks del repo y el encoder
        UserRepository repo = mock(UserRepository.class);
        PasswordEncoder encoder = mock(PasswordEncoder.class);
        GenerateVerificationToken tokenGen = mock(GenerateVerificationToken.class);
        EmailService emailService = mock(EmailService.class);

        //COLOCAR EL ALL ARGS CONST
        RegisterUser useCase = new RegisterUser(repo, encoder, tokenGen, emailService);

        RegisterUserCommand cmd = new RegisterUserCommand(
            "Franco",
            "franco@mail.com",
            "1234"
        );

        // mock behavior
        when(repo.findByEmail("franco@mail.com")).thenReturn(null);
        when(encoder.encode("1234")).thenReturn("hashed1234");
        when(repo.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(tokenGen.create(any())).thenReturn("dummy-token");

        // Act
        User result = useCase.execute(cmd);

        // Assert
        assertNotNull(result);
        assertEquals("Franco", result.getName());
        assertEquals("franco@mail.com", result.getEmail());
        assertEquals("hashed1234", result.getPassword());

        // verify interactions
        verify(repo).findByEmail("franco@mail.com");
        verify(encoder).encode("1234");
        verify(repo).save(result);
        verify(tokenGen).create(result.getId());
        verify(emailService).sendVerificationEmail("franco@mail.com", "dummy-token");
    }

    @Test
    void shouldThrowWhenEmailIsAlreadyTaken() {
        // Arrange
        UserRepository repo = mock(UserRepository.class);
        PasswordEncoder encoder = mock(PasswordEncoder.class);
        GenerateVerificationToken tokenGen = mock(GenerateVerificationToken.class);
        EmailService emailService = mock(EmailService.class);

        RegisterUser useCase = new RegisterUser(repo, encoder, tokenGen, emailService);

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