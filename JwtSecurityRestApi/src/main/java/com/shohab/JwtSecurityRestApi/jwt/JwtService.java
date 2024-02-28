package com.shohab.JwtSecurityRestApi.jwt;

import com.shohab.JwtSecurityRestApi.model.User;
import com.shohab.JwtSecurityRestApi.respository.TokenRepository;
import lombok.RequiredArgsConstructor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService  {
    private final TokenRepository tokenRepository;
    private final String SECREAT_KEY="d169552a202ace4ed9b31a326df08a2aa723e197a10213030f7c4be596ba99b6";

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
        return (Date) extractClaim(token,Claims::getExpiration);
    }

    public  boolean isValid(String token, UserDetails user){
        String username=extractUsername(token);

        boolean validToken=tokenRepository
                .findByToken(token)
                .map(t ->!t.isLoggedOut())
                .orElse(false);

        return (username.equals(user.getUsername()))&& !isTokenExpired(token)&& validToken;
    }

    public <T> T extractClaim(String token, Function<Claims,T>resolver){
        Claims claims=extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSigninKey(){
       byte[] keyBytes= Decoders.BASE64URL.decode(SECREAT_KEY);
       return Keys.hmacShaKeyFor(keyBytes);

    }

    public String generateToken(User user){
        String token=Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+24*60*60*1000))
                .signWith(getSigninKey())
                .compact();
        return token;
    }



}
