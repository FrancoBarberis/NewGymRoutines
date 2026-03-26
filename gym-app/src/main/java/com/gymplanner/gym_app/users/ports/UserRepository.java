package com.gymplanner.gym_app.users.ports;
import com.gymplanner.gym_app.users.domain.User;
import java.util.UUID;

public interface UserRepository {
    User save (User user);
    User findByEmail (String email);
    void deleteById (UUID id);
    User update (User user);
    User findById (UUID id);
}