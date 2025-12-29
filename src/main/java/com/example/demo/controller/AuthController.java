// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @PostMapping("/register")
//     public Map<String, Object> register() {
//         Map<String, Object> response = new HashMap<>();
//         response.put("message", "registered");
//         return response;
//     }

//     @PostMapping("/login")
//     public Map<String, Object> login() {
//         Map<String, Object> response = new HashMap<>();
//         response.put("token", "dummy-token");
//         return response;
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.AuthService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }
}
