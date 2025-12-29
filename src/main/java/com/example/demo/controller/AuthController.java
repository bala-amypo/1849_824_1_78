package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public Map<String, Object> register() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "registered");
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login() {
        Map<String, Object> response = new HashMap<>();
        response.put("token", "dummy-token");
        return response;
    }
}
 