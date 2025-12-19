package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController{
    @Autowired
    private UserService u;
    @PostMapping("/user")
    public User addUser(@RequestBody User us){
        return u.createUser(us);
    }
}