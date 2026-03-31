package com.gymplanner.gym_app.users.usecases.modification;

import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.EmailService;
import com.gymplanner.gym_app.users.ports.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditUser {
    private final UserRepository UserRepository;
    private final EmailService EmailService;

    public User execute(){
        //TODO
        return null;
    }
}
