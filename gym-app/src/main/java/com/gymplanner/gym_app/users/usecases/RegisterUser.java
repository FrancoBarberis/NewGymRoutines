package com.gymplanner.gym_app.users.usecases;
import com.gymplanner.gym_app.users.ports.UserRepository;
import com.gymplanner.gym_app.users.domain.User;

public class RegisterUser {
    private final UserRepository userRepository;

    // constructor
    public RegisterUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("Email already in use");
        }
        return userRepository.save(user);
    }
}
