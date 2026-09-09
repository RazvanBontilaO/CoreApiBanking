package com.example.banking.security;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public String generateToken(String username) {
        long expirationTime = 864_000_000;
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token){
        return getClaims(token).getPayload().getSubject();
    }

    public boolean validateToken(String token){
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Jws<Claims> getClaims(String token){
        return Jwts.parser().verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);
    }
}
