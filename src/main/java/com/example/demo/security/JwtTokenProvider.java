package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class JwtTokenProvider {

    private final String secret;
    private final long expirationMillis;

    // Constructor required by tests
    public JwtTokenProvider(String secret, long expirationMillis) {
        this.secret = secret;
        this.expirationMillis = expirationMillis;
    }

    // Default constructor for Spring
    public JwtTokenProvider() {
        this.secret = "VerySecretKeyForJwtDemoApplication123456";
        this.expirationMillis = 3600000L;
    }

    // Generate a simple token
    public String generateToken(String username, String role) {
        long expiryTime = System.currentTimeMillis() + expirationMillis;
        String rawToken = username + "|" + role + "|" + expiryTime;
        return Base64.getEncoder()
                .encodeToString(rawToken.getBytes(StandardCharsets.UTF_8));
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            String decoded = decode(token);
            String[] parts = decoded.split("\\|");
            if (parts.length != 3) return false;

            long expiryTime = Long.parseLong(parts[2]);
            return expiryTime >= System.currentTimeMillis();
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return decode(token).split("\\|")[0];
    }

    public String getRoleFromToken(String token) {
        return decode(token).split("\\|")[1];
    }

    private String decode(String token) {
        return new String(
                Base64.getDecoder().decode(token),
                StandardCharsets.UTF_8
        );
    }
}
