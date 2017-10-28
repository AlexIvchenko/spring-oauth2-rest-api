package com.github.alexivchenko.springoauth2restapi.repository;

import com.github.alexivchenko.springoauth2restapi.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alex Ivchenko
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
