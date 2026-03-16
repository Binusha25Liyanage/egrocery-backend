package com.egrocery_remasterd.egrocery_backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import com.egrocery_remasterd.egrocery_backend.model.Role;

import java.security.Key;
import java.util.Date;
import java.util.Set;

@Service
public class JwtService {

    private final String SECRET = "your-very-secure-secret-key-your-very-secure-secret-key";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String email, Set<Role> roles) {
        return Jwts.builder()
                .setSubject(email)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
