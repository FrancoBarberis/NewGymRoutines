package com.gymplanner.gym_app.users.infrastructure.jpa;

import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.infrastructure.jpa.entities.UserEntity;

public class UserMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPassword());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getNombre(),
                userEntity.getEmail(),
                userEntity.getHashedPassword());
    }
}