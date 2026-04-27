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
@Table(name = "kitaplar")
public class Kitap {

    @Id
    @UuidGenerator()
    @Column(name = "kitap_id")
    private UUID kitapID;

    @Column(name = "kitap_ad", nullable = false, length = 150)
    private String kitapAd;

    @Column(name = "sayfa_sayisi")
    private int sayfaSayisi;

    @Column(name = "kitap_turu", length = 100)
    private String kitapTuru;

    @ManyToOne
    @JoinColumn(name = "yayinevi_no")
    private Yayinevi yayinevi;

    @ManyToOne
    @JoinColumn(name = "yazar_no")
    private Yazar yazar;

    @OneToMany(mappedBy = "kitap")
    private Set<KutuphaneKitap> kutuphaneKitaplar;

    @OneToMany(mappedBy = "kitap")
    private Set<OgrenciKitap> ogrenciKitaplar;

    public Set<KutuphaneKitap> getKutuphaneKitaplar() {
        return kutuphaneKitaplar;
    }

    public void setKutuphaneKitaplar(Set<KutuphaneKitap> kutuphaneKitaplar) {
        this.kutuphaneKitaplar = kutuphaneKitaplar;
    }

    public UUID getKitapID() {
        return kitapID;
    }

    public void setKitapID(UUID kitapID) {
        this.kitapID = kitapID;
    }

    public String getKitapAd() {
        return kitapAd;
    }

    public void setKitapAd(String kitapAd) {
        this.kitapAd = kitapAd;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getKitapTuru() {
        return kitapTuru;
    }

    public void setKitapTuru(String kitapTuru) {
        this.kitapTuru = kitapTuru;
    }

    public Yayinevi getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(Yayinevi yayinevi) {
        this.yayinevi = yayinevi;
    }

    public Yazar getYazar() {
        return yazar;
    }

    public void setYazar(Yazar yazar) {
        this.yazar = yazar;
    }

    public Set<OgrenciKitap> getOgrenciKitaplar() {
        return ogrenciKitaplar;
    }

    public void setOgrenciKitaplar(Set<OgrenciKitap> ogrenciKitaplar) {
        this.ogrenciKitaplar = ogrenciKitaplar;
    }

    
}