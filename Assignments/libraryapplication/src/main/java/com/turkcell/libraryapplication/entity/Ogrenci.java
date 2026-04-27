package com.turkcell.libraryapplication.entity;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ogrenciler")
public class Ogrenci {

    @Id
    @UuidGenerator()
    @Column(name = "ogrenci_id")
    private UUID ogrenciID;

    @Column(name = "ogrenci_ad", nullable = false, length = 150)
    private String ogrenciAd;

    @Column(name = "email", length = 150)
    private String email;

    @OneToMany(mappedBy = "ogrenci")
    private Set<KutuphaneOgrenci> kutuphaneOgrenciler;

    @OneToMany(mappedBy = "ogrenci")
    private Set<OgrenciKitap> ogrenciKitaplar;

    public UUID getOgrenciID() {
        return ogrenciID;
    }

    public void setOgrenciID(UUID ogrenciID) {
        this.ogrenciID = ogrenciID;
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

    public Set<KutuphaneOgrenci> getKutuphaneOgrenciler() {
        return kutuphaneOgrenciler;
    }

    public void setKutuphaneOgrenciler(Set<KutuphaneOgrenci> kutuphaneOgrenciler) {
        this.kutuphaneOgrenciler = kutuphaneOgrenciler;
    }

    public Set<OgrenciKitap> getOgrenciKitaplar() {
        return ogrenciKitaplar;
    }

    public void setOgrenciKitaplar(Set<OgrenciKitap> ogrenciKitaplar) {
        this.ogrenciKitaplar = ogrenciKitaplar;
    }

    

}
