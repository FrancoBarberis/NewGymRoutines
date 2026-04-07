package com.gymplanner.gym_app.users.usecases;

import com.gymplanner.gym_app.users.ports.EmailService;
import com.gymplanner.gym_app.users.ports.UserRepository;
import com.gymplanner.gym_app.users.usecases.verification.GenerateVerificationToken;
import com.gymplanner.gym_app.users.domain.User;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@AllArgsConstructor
public class RegisterUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final GenerateVerificationToken tokenGenerator;
    private final EmailService emailService;

    public User execute(RegisterUserCommand cmd) {

        // 1. Validar email existente
        User existingUser = userRepository.findByEmail(cmd.email());
        if (existingUser != null) {
            throw new IllegalArgumentException("Email already in use");
        }

        // 2. Hashear password
        String hashedPassword = passwordEncoder.encode(cmd.password());

        // 3. Crear usuario con verified = false
        User user = new User(
                UUID.randomUUID(),
                cmd.nombre(),
                cmd.email(),
                hashedPassword,
                false
        );

        // 4. Persistir usuario
        User saved = userRepository.save(user);

        // 5. Generar token de verificación
        String token = tokenGenerator.create(saved.getId());

        // 6. Enviar email con link de confirmación
        emailService.sendVerificationEmail(saved.getEmail(), token);

        return saved;
    }
}