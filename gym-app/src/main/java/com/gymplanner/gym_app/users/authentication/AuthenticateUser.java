import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticateUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticateUser(UserRepository userRepository,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(AuthenticateUserCommand cmd) {

        User user = userRepository.findByEmail(cmd.email());
        if (user == null) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        if (!passwordEncoder.matches(cmd.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        if (!user.isVerified()) {
            throw new IllegalStateException("User not verified");
        }

        return user;
    }
}