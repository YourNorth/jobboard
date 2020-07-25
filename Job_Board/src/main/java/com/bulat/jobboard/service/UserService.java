package com.bulat.jobboard.service;

import com.bulat.jobboard.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findByEmail(String email);

    void signUp(User user);

    User save(User user);
}
