package com.gymplanner.gym_app.users.web;

import org.springframework.web.bind.annotation.*;
import com.gymplanner.gym_app.users.usecases.RegisterUser;
import com.gymplanner.gym_app.users.usecases.RegisterUserCommand;
import com.gymplanner.gym_app.users.authentication.AuthenticateUserCommand;
import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.usecases.verification.ConfirmUser;
import com.gymplanner.gym_app.users.web.requests.AuthenticateUserRequest;
import com.gymplanner.gym_app.users.web.requests.RegisterUserRequest;
import com.gymplanner.gym_app.users.web.responses.AuthenticateUserResponse;
import com.gymplanner.gym_app.users.web.responses.RegisterUserResponse;
import com.gymplanner.gym_app.users.authentication.AuthenticateUser;

import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    // INYECCION DE CASOS DE USO

    private final RegisterUser registerUser;
    private final ConfirmUser confirmUser;
    private final AuthenticateUser authenticateUser;

    public UserController(RegisterUser registerUser, ConfirmUser confirmUser, AuthenticateUser authenticateUser) {
        this.registerUser = registerUser;
        this.confirmUser = confirmUser;
        this.authenticateUser = authenticateUser;
    }

    @PostMapping("/register")
    public RegisterUserResponse register(@Valid @RequestBody RegisterUserRequest request) {

        // Convertimos el DTO del controller en el command del caso de uso:
        RegisterUserCommand cmd = new RegisterUserCommand(
                request.nombre(),
                request.email(),
                request.password());

        // ejecutamos el caso de uso
        User user = registerUser.execute(cmd);

        // devolvemos el response
        return RegisterUserResponse.from(user);
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestParam String token) {
        confirmUser.execute(token);
        return ResponseEntity.ok("User confirmed successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticateUserResponse> login(
            @Valid @RequestBody AuthenticateUserRequest request) {

        AuthenticateUserCommand cmd = new AuthenticateUserCommand(
                request.email(),
                request.password());

        User user = authenticateUser.execute(cmd);

        return ResponseEntity.ok(
                AuthenticateUserResponse.from(user));
    }

}