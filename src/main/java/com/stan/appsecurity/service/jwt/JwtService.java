package com.stan.appsecurity.service.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {

    public String generateToken(UserDetails userDetails);
    public String generateRefreshToken(Map<String, String> extraClaims, UserDetails userDetails);
    public Claims extractClaims(String token);
    public String extractUsername(String token);
    public boolean isTokenValid(String token, UserDetails userDetails);
}
