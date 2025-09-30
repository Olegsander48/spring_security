package com.udemy.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails ivan = User.builder()
                .username("ivan")
                .password(encoder.encode("1234"))
                .roles("EMPLOYEE")
                .build();

        UserDetails elena = User.builder()
                .username("elena")
                .password(encoder.encode("1234"))
                .roles("HR")
                .build();

        UserDetails andrey = User.builder()
                .username("andrey")
                .password(encoder.encode("1234"))
                .roles("HR", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(ivan, elena, andrey);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
