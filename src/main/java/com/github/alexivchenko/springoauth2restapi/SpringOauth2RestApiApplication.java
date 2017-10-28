package com.github.alexivchenko.springoauth2restapi;

import com.github.alexivchenko.springoauth2restapi.model.Role;
import com.github.alexivchenko.springoauth2restapi.model.User;
import com.github.alexivchenko.springoauth2restapi.repository.UserRepository;
import com.github.alexivchenko.springoauth2restapi.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

import static java.util.Arrays.asList;

@SpringBootApplication
public class SpringOauth2RestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2RestApiApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder auth, UserRepository userRepository) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.save(new User("user", "user", asList(new Role("ROLE_USER"))));
        }
        auth.userDetailsService(userDetailsService(userRepository));
    }

    @Bean
    @Autowired
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsServiceImpl(userRepository);
    }
}
