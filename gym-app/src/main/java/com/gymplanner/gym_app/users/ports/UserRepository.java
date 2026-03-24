package com.gymplanner.gym_app.users.ports;
import com.gymplanner.gym_app.users.domain.User;

public interface UserRepository {
    User save (User user);
    User findByEmail (String email);
    void deleteById (Long id);
    User update (User user);
}