package com.bulat.jobboard.config;

import com.bulat.jobboard.model.Role;
import com.bulat.jobboard.model.State;
import com.bulat.jobboard.model.User;
import com.bulat.jobboard.security.details.UserDetailsImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User user = new User("user@company.com", "password");
        user.setStatus(State.ACTIVE);
        user.setRoles(Collections.singletonList(Role.builder().name("ROLE_CANDIDATE").build()));

        User employer = new User("employer@company.com", "password");
        employer.setStatus(State.ACTIVE);
        employer.setRoles(Collections.singletonList(Role.builder().name("ROLE_EMPLOYER").build()));

        User admin = new User("admin@company.com", "password");
        admin.setStatus(State.ACTIVE);
        admin.setRoles(Collections.singletonList(Role.builder().name("ROLE_ADMIN").build()));

        return new InMemoryUserDetailsManager(new UserDetailsImpl(user),
                new UserDetailsImpl(employer), new UserDetailsImpl(admin));
    }
}
