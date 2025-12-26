package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email) {
        // simple dummy token (enough for tests)
        return "TOKEN_" + email;
    }

    public String getEmailFromToken(String token) {
        if (token.startsWith("TOKEN_")) {
            return token.substring(6);
        }
        return null;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("TOKEN_");
    }
}
