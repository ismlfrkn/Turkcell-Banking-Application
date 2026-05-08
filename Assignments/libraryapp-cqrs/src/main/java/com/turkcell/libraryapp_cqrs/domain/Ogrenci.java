package com.turkcell.libraryapp_cqrs.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ogrenciler")
public class Ogrenci {
    @Id
    @UuidGenerator()
    @Column(name = "ogrenci_id", nullable = false)
    private UUID ogrenciId;

    @Column(name = "ogrenci_ad", nullable = false)
    @NotBlank(message = "Öğrenci adi boş olamaz")
    private String ogrenciAd;

    @NotBlank(message = "Email boş olamaz")
    @Email(message = "Geçerli bir email giriniz")
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "ogrenci", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OgrenciKitap> ogrenciKitaplar = new HashSet<>();

    @OneToMany(mappedBy = "ogrenci", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KutuphaneOgrenci> kutuphaneOgrenciler = new HashSet<>();

    

    public UUID getOgrenciId() {
        return ogrenciId;
    }

    public void setOgrenciId(UUID ogrenciId) {
        this.ogrenciId = ogrenciId;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public void setOgrenciAd(String ogrenciAd) {
        this.ogrenciAd = ogrenciAd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OgrenciKitap> getOgrenciKitaplar() {
        return ogrenciKitaplar;
    }

    public void setOgrenciKitaplar(Set<OgrenciKitap> ogrenciKitaplar) {
        this.ogrenciKitaplar = ogrenciKitaplar;
    }

    public Set<KutuphaneOgrenci> getKutuphaneOgrenciler() {
        return kutuphaneOgrenciler;
    }

    public void setKutuphaneOgrenciler(Set<KutuphaneOgrenci> kutuphaneOgrenciler) {
        this.kutuphaneOgrenciler = kutuphaneOgrenciler;
    }

    

}
