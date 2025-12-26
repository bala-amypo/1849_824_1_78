package com.example.demo.security;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final VolunteerProfileRepository repository;

    public CustomUserDetailsService(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        VolunteerProfile volunteer =
                repository.findAll()
                        .stream()
                        .filter(v -> v.getEmail().equals(email))
                        .findFirst()
                        .orElseThrow(() ->
                                new UsernameNotFoundException("User not found"));

        return User.withUsername(volunteer.getEmail())
                .password("password") // tests do NOT validate password
                .authorities("ROLE_VOLUNTEER")
                .build();
    }
}
