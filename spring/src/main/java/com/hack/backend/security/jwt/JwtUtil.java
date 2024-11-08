package com.hack.backend.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.access-expiration}")
    private Long accessExpiration;

    private final RedisTemplate<String, String> redisTemplate;

    public String createToken(String id) {
        Claims claims = Jwts.claims();
        claims.put("id", id);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + accessExpiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        redisTemplate.opsForValue().set(id, token, accessExpiration, TimeUnit.MICROSECONDS);

        return token;
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);


            String id = claims.getBody().get("id", String.class);
            String storedToken = redisTemplate.opsForValue().get(id);

            return storedToken != null && storedToken.equals(token);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);

        }
    }

}
