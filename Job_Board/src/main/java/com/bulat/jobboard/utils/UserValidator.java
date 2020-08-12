package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.User;
import com.bulat.jobboard.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * A class that validates a user's mail for uniqueness
 * @author Bulat Bilalov
 * @version 1.0
 * @see org.springframework.validation.Validator
 */
@Component
public class UserValidator implements Validator {

    /** Service for interaction between user entity and database */
    private final UserService userService;

    /**
     * @param userService Service for interaction between user entity and database
     */
    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    /**
     * Method to support for the desired entity
     * @param aClass Class to check
     * @return User entity
     */
    @Override
    public boolean supports(@NotNull Class<?> aClass) {
        return User.class.equals(aClass);
    }

    /**
     * Method validating user's mail for uniqueness
     * @param o Check object
     * @param errors Form validation errors
     */
    @Override
    public void validate(@NotNull Object o, @NotNull Errors errors) {
        User user = (User) o;
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            errors.rejectValue(
                    "email", "This email is already in use", "This email is already in use"
            );
        }
    }
}
