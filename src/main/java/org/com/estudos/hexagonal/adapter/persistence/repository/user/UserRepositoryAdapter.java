package org.com.estudos.hexagonal.adapter.persistence.repository.user;

import lombok.AllArgsConstructor;
import org.com.estudos.hexagonal.adapter.mapper.UserMapper;
import org.com.estudos.hexagonal.adapter.persistence.entity.UserEntity;
import org.com.estudos.hexagonal.domain.entity.User;
import org.com.estudos.hexagonal.domain.port.outbound.repository.UserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String name) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(name);
        if (userEntity.isEmpty()) return Optional.empty();
        return Optional.of(UserMapper.toDomain(userEntity.get()));
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userRepository.save(UserMapper.toPersistence(user));
        return UserMapper.toDomain(userEntity);
    }
}
