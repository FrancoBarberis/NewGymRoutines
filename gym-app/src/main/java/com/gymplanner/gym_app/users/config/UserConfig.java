package com.gymplanner.gym_app.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gymplanner.gym_app.users.ports.UserRepository;
import com.gymplanner.gym_app.users.usecases.RegisterUser;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    public RegisterUser registerUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new RegisterUser(userRepository, passwordEncoder);
    }
}