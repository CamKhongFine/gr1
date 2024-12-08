package com.example.security.Jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "IWillTellYouThisIsNotMySecretKey";
    private static final long EXPIRATION_TIME = 60 * 1000; //Token expired within 1 minute
    private static final long FIXED_INTERVAL = 60 * 1000;

    public static String generateToken(String username, String roles) {
        long currentTimeMillis = System.currentTimeMillis();
        // Round to minute
        long roundedTimeMillis = (currentTimeMillis / FIXED_INTERVAL) * FIXED_INTERVAL;

        Date issuedAt = new Date(roundedTimeMillis);
        Date expiration = new Date(roundedTimeMillis + EXPIRATION_TIME);

        return Jwts.builder()
                .subject(username)
                .issuedAt(issuedAt)
                .claim("roles", roles)
                .expiration(expiration)
                .signWith(getSignInKey())
                .compact();
    }

    private static SecretKey getSignInKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
