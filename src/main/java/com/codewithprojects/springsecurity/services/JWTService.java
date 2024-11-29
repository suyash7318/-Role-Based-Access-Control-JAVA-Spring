package com.codewithprojects.springsecurity.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class JWTService {

    private final String SECRET_KEY = "your_secret_key_here"; // Replace with your actual secret key

    public String generateToken(String username) {
        // Generate JWT with username
        return Jwts.builder()
                .setSubject(username) // Store username in the token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String generateRefreshToken(HashMap<String, Object> claims, String username) {
        // Generate refresh token with claims
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // 7 days validity
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
