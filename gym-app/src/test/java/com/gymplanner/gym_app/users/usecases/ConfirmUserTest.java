package com.gymplanner.gym_app.users.usecases;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.UserRepository;
import com.gymplanner.gym_app.users.ports.VerificationTokenRepository;
import com.gymplanner.gym_app.users.usecases.verification.ConfirmUser;
import com.gymplanner.gym_app.users.usecases.verification.VerificationToken;

public class ConfirmUserTest {

    @Test
    void shouldConfirmUserSuccessfully() {
        VerificationTokenRepository tokenRepo = mock(VerificationTokenRepository.class);
        UserRepository userRepo = mock(UserRepository.class);

        ConfirmUser useCase = new ConfirmUser(tokenRepo, userRepo);

        String dummyToken = "dummy-token-123";
        UUID userId = UUID.randomUUID();
        User user = new User(userId, "Franco", "franco@mail.com", "hashed123");
        
        when(tokenRepo.findByToken(dummyToken)).thenReturn(new VerificationToken(dummyToken, userId));
        when(userRepo.findById(userId)).thenReturn(user);

        // Act
        useCase.execute(dummyToken);

        // Assert
        assertTrue(user.isVerified());
        verify(userRepo).update(user);
    }

    @Test
    void shouldThrowWhenTokenIsInvalid() {
        VerificationTokenRepository tokenRepo = mock(VerificationTokenRepository.class);
        UserRepository userRepo = mock(UserRepository.class);

        ConfirmUser useCase = new ConfirmUser(tokenRepo, userRepo);

        String invalidToken = "invalid-token";
        
        when(tokenRepo.findByToken(invalidToken)).thenReturn(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> useCase.execute(invalidToken));
        verify(userRepo, never()).update(any());
    }
}
