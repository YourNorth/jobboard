package com.bulat.jobboard.security.service;

import com.bulat.jobboard.model.User;
import com.bulat.jobboard.security.details.UserDetailsImpl;
import com.bulat.jobboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service responsible for finding a user by mail
 * @author Bulat Bilalov
 * @version 1.0
 * @see org.springframework.security.core.userdetails.UserDetailsService
 */
@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    /** A service that allows a class to interact with a database */
    private final UserService userService;

    /**
     * The constructor that receives UserService
     * @param userService Service that allows a class to interact with a database
     */
    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * User upload and check method by mail
     * @param email Mail by which the user is searched
     * @return If the user is, then it returns UserDetailsImpl otherwise UsernameNotFoundException
     * @throws UsernameNotFoundException if the user isn't
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()) {
            User userSimple = userOptional.get();
            return new UserDetailsImpl(userSimple);
        } throw new UsernameNotFoundException("User not found");
    }

}
