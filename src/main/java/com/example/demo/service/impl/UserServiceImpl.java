package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User saveUser(User user) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public User findByEmail(String email) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean existsByEmail(String email) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
