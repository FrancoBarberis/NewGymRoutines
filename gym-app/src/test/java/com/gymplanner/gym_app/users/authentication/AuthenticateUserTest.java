package com.gymplanner.gym_app.users.authentication;

import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticateUserTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticateUser authenticateUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAuthenticateUserSuccessfully() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        User user = new User(UUID.randomUUID(), "Test User", email, "hashedPassword", true);
        AuthenticateUserCommand cmd = new AuthenticateUserCommand(email, password);

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(true);

        // Act
        User result = authenticateUser.execute(cmd);

        // Assert
        assertEquals(user, result);
        verify(userRepository).findByEmail(email);
        verify(passwordEncoder).matches(password, user.getPassword());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        // Arrange
        String email = "nonexistent@example.com";
        AuthenticateUserCommand cmd = new AuthenticateUserCommand(email, "password");

        when(userRepository.findByEmail(email)).thenReturn(null);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> authenticateUser.execute(cmd));
        assertEquals("Invalid credentials", exception.getMessage());
        verify(userRepository).findByEmail(email);
        verifyNoInteractions(passwordEncoder);
    }

    @Test
    void shouldThrowExceptionWhenPasswordDoesNotMatch() {
        // Arrange
        String email = "test@example.com";
        User user = new User(UUID.randomUUID(), "Test User", email, "hashedPassword", true);
        AuthenticateUserCommand cmd = new AuthenticateUserCommand(email, "wrongPassword");

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(passwordEncoder.matches("wrongPassword", user.getPassword())).thenReturn(false);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> authenticateUser.execute(cmd));
        assertEquals("Invalid credentials", exception.getMessage());
        verify(userRepository).findByEmail(email);
        verify(passwordEncoder).matches("wrongPassword", user.getPassword());
    }

    @Test
    void shouldThrowExceptionWhenUserNotVerified() {
        // Arrange
        String email = "test@example.com";
        User user = new User(UUID.randomUUID(), "Test User", email, "hashedPassword", false);
        AuthenticateUserCommand cmd = new AuthenticateUserCommand(email, "password");

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(passwordEncoder.matches("password", user.getPassword())).thenReturn(true);

        // Act & Assert
        IllegalStateException exception = assertThrows(IllegalStateException.class,
            () -> authenticateUser.execute(cmd));
        assertEquals("User not verified", exception.getMessage());
        verify(userRepository).findByEmail(email);
        verify(passwordEncoder).matches("password", user.getPassword());
    }
}