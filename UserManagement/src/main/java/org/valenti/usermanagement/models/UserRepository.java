package org.valenti.usermanagement.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Iterable<User> findByUsernameContainsIgnoreCase(String username);
}
