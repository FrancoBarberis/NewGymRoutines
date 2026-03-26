package com.gymplanner.gym_app.users.infrastructure.jpa;

import org.springframework.stereotype.Repository;

import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.ports.UserRepository;
import com.gymplanner.gym_app.users.infrastructure.jpa.entities.UserEntity;

import java.util.UUID;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repo;
    private final UserMapper mapper = new UserMapper();

    public JpaUserRepository(SpringDataUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity saved = repo.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public User findById(UUID id) {
        return repo.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public User update(User user) {
        // save() en Spring Data hace update si ya existe
        return save(user);
    }
}