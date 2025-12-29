// package com.example.demo.security;

// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import java.nio.charset.StandardCharsets;
// import java.util.Base64;
// import java.util.HashMap;
// import java.util.Map;

// @Component
// public class JwtTokenProvider {

//     private String secret;
//     private long expirationMs;

//     // ✅ REQUIRED by Spring Boot at runtime
//     public JwtTokenProvider() {
//         this.secret = "VerySecretKeyForJwtDemoApplication123456";
//         this.expirationMs = 3600000L;
//     }

//     // ✅ USED BY TEST CASES
//     public JwtTokenProvider(String secret, long expirationMs) {
//         this.secret = secret;
//         this.expirationMs = expirationMs;
//     }

//     public String generateToken(Authentication authentication,
//                                 Long userId,
//                                 String role) {

//         String email = authentication.getName();

//         String payload =
//                 email + "|" +
//                 userId + "|" +
//                 role + "|" +
//                 (System.currentTimeMillis() + expirationMs);

//         return Base64.getEncoder()
//                 .encodeToString(payload.getBytes(StandardCharsets.UTF_8));
//     }

//     public boolean validateToken(String token) {
//         try {
//             decode(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String getUsernameFromToken(String token) {
//         return getAllClaims(token).get("email").toString();
//     }

//     public Map<String, Object> getAllClaims(String token) {
//         String decoded = decode(token);
//         String[] parts = decoded.split("\\|");

//         Map<String, Object> claims = new HashMap<>();
//         claims.put("email", parts[0]);
//         claims.put("userId", Long.parseLong(parts[1]));
//         claims.put("role", parts[2]);

//         return claims;
//     }

//     private String decode(String token) {
//         byte[] decoded = Base64.getDecoder().decode(token);
//         return new String(decoded, StandardCharsets.UTF_8);
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    private final String jwtSecret;
    private final long jwtExpirationInMs;
    private final SecretKey key;

    public JwtTokenProvider() {
        this.jwtSecret = "VerySecretKeyForJwtDemoApplication123456";
        this.jwtExpirationInMs = 3600000L;
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public JwtTokenProvider(String secret, long expiration) {
        this.jwtSecret = secret;
        this.jwtExpirationInMs = expiration;
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(Authentication authentication, Long userId, String role) {
        String username = authentication.getName();
        Date expiryDate = new Date(System.currentTimeMillis() + jwtExpirationInMs);

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);
        claims.put("email", username);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Map<String, Object> getAllClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Map<String, Object> result = new HashMap<>();
        result.put("userId", claims.get("userId"));
        result.put("role", claims.get("role"));
        result.put("email", claims.get("email"));
        return result;
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            // Invalid JWT token
        } catch (ExpiredJwtException ex) {
            // Expired JWT token
        } catch (UnsupportedJwtException ex) {
            // Unsupported JWT token
        } catch (IllegalArgumentException ex) {
            // JWT claims string is empty
        }
        return false;
    }
}