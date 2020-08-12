package com.bulat.jobboard.security.details;

import com.bulat.jobboard.model.State;
import com.bulat.jobboard.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * A class responsible for various features spring security by user
 * @author Bulat Bilalov
 * @version 1.0
 * @see org.springframework.security.core.userdetails.UserDetails
 */
public class UserDetailsImpl implements UserDetails {

    /** Register user */
    private final User user;

    /**
     * Constructor receiving user
     * @param user Register user
     */
    public UserDetailsImpl(User user) {
        this.user = user;
    }

    /**
     * User object getter method
     * @return User object
     */
    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus().equals(State.ACTIVE);
    }
}