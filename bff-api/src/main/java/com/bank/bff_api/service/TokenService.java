package com.bank.bff_api.service;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {
    private final String secretKey =
            "ME9C2HFIlYVaQ6nsgurtIxo8N5xhthmQI7a6gCptSj0fHLPEtaaXh3ZVQzIhAP/7e3Mm6qZiHWZUTMyEQD/7tzK6qZ4h3ZVQzIhA==";

    public String generateToken(String userName) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusSeconds(3600)))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
