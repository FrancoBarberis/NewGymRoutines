package com.gymplanner.gym_app.users.infrastructure.jpa;

import com.gymplanner.gym_app.users.ports.UserRepository;
import org.springframework.stereotype.Repository;
import com.gymplanner.gym_app.users.domain.User;
import com.gymplanner.gym_app.users.infrastructure.jpa.entities.UserEntity;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repo;
    private final UserMapper mapper = new UserMapper();

    public JpaUserRepository (SpringDataUserRepository repo){
        this.repo = repo;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public User update(User user) {
        // TODO Auto-generated method stub
        return null;
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
}
