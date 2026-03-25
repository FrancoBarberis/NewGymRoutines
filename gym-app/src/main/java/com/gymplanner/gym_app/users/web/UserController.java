package com.gymplanner.gym_app.users.web;

import org.springframework.web.bind.annotation.*;
import com.gymplanner.gym_app.users.usecases.RegisterUser;
import com.gymplanner.gym_app.users.usecases.RegisterUserCommand;
import com.gymplanner.gym_app.users.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUser registerUser;

    public UserController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/register")
    public RegisterUserResponse register(@RequestBody RegisterUserRequest request) {

        // Convertimos el DTO del controller en el command del caso de uso:
        RegisterUserCommand cmd = new RegisterUserCommand(
            request.nombre(),
            request.email(),
            request.password()
        );

        // ejecutamos el caso de uso
        User user = registerUser.execute(cmd);

        // devolvemos el response
        return RegisterUserResponse.from(user);
    }
}