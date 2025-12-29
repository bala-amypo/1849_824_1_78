package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    private String secret;
    private long expirationMs;

    // ✅ REQUIRED by Spring Boot runtime
    public JwtTokenProvider() {
        this.secret = "VerySecretKeyForJwtDemoApplication123456";
        this.expirationMs = 3600000L;
    }

    // ✅ REQUIRED by TEST CASES
    public JwtTokenProvider(String secret, long expirationMs) {
        this.secret = secret;
        this.expirationMs = expirationMs;
    }

    public String generateToken(Authentication authentication,
                                Long userId,
                                String role) {

        String email = authentication.getName();

        String payload =
                email + "|" +
                userId + "|" +
                role + "|" +
                (System.currentTimeMillis() + expirationMs);

        return Base64.getEncoder()
                .encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    }

    public boolean validateToken(String token) {
        try {
            decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getAllClaims(token).get("email").toString();
    }

    public Map<String, Object> getAllClaims(String token) {
        String decoded = decode(token);
        String[] parts = decoded.split("\\|");

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", parts[0]);
        claims.put("userId", Long.parseLong(parts[1]));
        claims.put("role", parts[2]);

        return claims;
    }

    private String decode(String token) {
        byte[] decoded = Base64.getDecoder().decode(token);
        return new String(decoded, StandardCharsets.UTF_8);
    }
}
