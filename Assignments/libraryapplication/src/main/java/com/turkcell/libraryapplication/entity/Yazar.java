package com.turkcell.libraryapplication.entity;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "yazarlar")
public class Yazar {

    @Id
    @UuidGenerator
    @Column(name = "yazar_no")
    private UUID yazarNo;

    @Column(name = "yazar_ad", nullable = false, length = 150)
    private String yazarAd;

    @Column(name = "ulke", length = 100)
    private String ulke;

    @ManyToOne
    @JoinColumn(name = "yayinevi_no")
    private Yayinevi yayinevi;

    @OneToMany(mappedBy = "yazar")
    private Set<Kitap> kitaplar;

    public UUID getYazarNo() {
        return yazarNo;
    }

    public void setYazarNo(UUID yazarNo) {
        this.yazarNo = yazarNo;
    }

    public String getYazarAd() {
        return yazarAd;
    }

    public void setYazarAd(String yazarAd) {
        this.yazarAd = yazarAd;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    public Yayinevi getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(Yayinevi yayinevi) {
        this.yayinevi = yayinevi;
    }

    public Set<Kitap> getKitaplar() {
        return kitaplar;
    }

    public void setKitaplar(Set<Kitap> kitaplar) {
        this.kitaplar = kitaplar;
    }


}
