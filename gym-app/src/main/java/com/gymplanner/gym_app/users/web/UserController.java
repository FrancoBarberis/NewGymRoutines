package com.gymplanner.gym_app.users.web;

import org.springframework.web.bind.annotation.*;
import com.gymplanner.gym_app.users.usecases.RegisterUser;
import com.gymplanner.gym_app.users.usecases.RegisterUserCommand;
import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.usecases.verification.ConfirmUser;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegisterUser registerUser;
    private final ConfirmUser confirmUser;

    public UserController(RegisterUser registerUser, ConfirmUser confirmUser) {
        this.registerUser = registerUser;
        this.confirmUser = confirmUser;
    }

    @PostMapping("/register")
    public RegisterUserResponse register(@Valid @RequestBody RegisterUserRequest request) {

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

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestParam String token) {
        try {
            confirmUser.execute(token);
            return ResponseEntity.ok("User confirmed successfully!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}