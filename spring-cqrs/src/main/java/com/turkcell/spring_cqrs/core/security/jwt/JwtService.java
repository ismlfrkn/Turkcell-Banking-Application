package com.turkcell.spring_cqrs.core.security.jwt;



import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
@EnableConfigurationProperties(JwpPropeties.class) //Configuration'dan okuma yapan sınıfı enable ediyoruz.
public class JwtService {
    private final JwpPropeties jwtPropeties;
    private final SecretKey signingKey;
    
    
    public JwtService(JwpPropeties jwtPropeties) {
        this.jwtPropeties = jwtPropeties;

        byte[] keyBytes = Decoders.BASE64.decode(jwtPropeties.getSecret()); //Secret çözülerek gerçek değer byte şeklinde tutulur.
        this.signingKey = Keys.hmacShaKeyFor(keyBytes); //Bu tutulan değer JWT imzalamaya uygun gerçek bir güvenlik anahtarına dönüştürülür.
    }

    //Core katmanında herkesin kullanabileceği kod yazılmalıdır.(O yüzden parametreye normal öğrenci kısmını vermedik.)
    public String generate(UUID userId,String email)
    {
        Instant now = Instant.now();
        return Jwts.builder()
        .issuer(this.jwtPropeties.getIssuer())
        .subject(userId.toString())
        .claim("email",email)
        .claim("deneme", "deneme")
        .issuedAt(Date.from(now))
        .expiration(Date.from(now.plusSeconds(this.jwtPropeties.getExpirationSeconds())))
        .signWith(this.signingKey)
        .compact();
    }


   
    

    
}
