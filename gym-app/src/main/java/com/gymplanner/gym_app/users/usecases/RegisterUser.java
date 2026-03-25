package com.gymplanner.gym_app.users.usecases;

import com.gymplanner.gym_app.users.ports.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gymplanner.gym_app.users.domain.User;
import java.util.UUID;

public class RegisterUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // constructor
    public RegisterUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(RegisterUserCommand cmd) {

        // 1. Validar email existente
        User existingUser = userRepository.findByEmail(cmd.email());
        if (existingUser != null) {
            throw new IllegalArgumentException("Email already in use");
        }

        // 2. Hashear password
        String hashedPassword = passwordEncoder.encode(cmd.password());

        // 3. Crear el User del dominio
        User user = new User(
                UUID.randomUUID(),
                cmd.nombre(),
                cmd.email(),
                hashedPassword);

        // 4. Guardar
        return userRepository.save(user);
    }
}
