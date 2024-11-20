package com.javajobs.domain.login;

import java.util.Optional;

public interface LoginRepository {
    Optional<User> findByUsername(String username);

    User save(User user);
}