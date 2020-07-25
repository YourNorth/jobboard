package com.bulat.jobboard.service.impl;

import com.bulat.jobboard.model.Role;
import com.bulat.jobboard.model.State;
import com.bulat.jobboard.model.User;
import com.bulat.jobboard.repository.UserRepository;
import com.bulat.jobboard.service.RoleService;
import com.bulat.jobboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void signUp(User user) {
        Optional<Role> roleUser = roleService.findByName("ROLE_USER");
        roleUser.ifPresent(role -> user.setRoles(Collections.singletonList(role)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(State.ACTIVE);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
