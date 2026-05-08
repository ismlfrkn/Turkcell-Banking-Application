package com.turkcell.spring_cqrs.core.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "security.jwt")
public class JwpPropeties {
    private String secret; //Anahtarımız 'openssl rand -base64 48' ile oluşturulur fakat openssl kurulu olması gerekiyor.
    private long expirationSeconds = 360000;
    private String issuer = "spring_cqrs"; //JWT token’ını hangi uygulamanın / servisin ürettiğini belirten bilgidir.
    //Bu bilgiler kodun içinde bulunmaz application.yaml'dan okunur.
    
    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public long getExpirationSeconds() {
        return expirationSeconds;
    }
    public void setExpirationSeconds(long expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
    }
    public String getIssuer() {
        return issuer;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    
}
