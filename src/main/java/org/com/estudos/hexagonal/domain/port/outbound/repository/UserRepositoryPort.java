package org.com.estudos.hexagonal.domain.port.outbound.repository;

import org.com.estudos.hexagonal.domain.entity.User;

import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findByEmail(String name);

    User save(User user);
}
