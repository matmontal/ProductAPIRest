package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("testuser")
                .password("{noop}password") // "{noop}" indica que no se está codificando la contraseña.
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}