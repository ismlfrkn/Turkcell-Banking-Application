package com.turkcell.libraryapplication.entity;

import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "kutuphaneler")
public class Kutuphane {

    @Id
    @UuidGenerator
    @Column(name = "kutuphane_id")
    private UUID kutuphaneID;

    @Column(name = "kutuphane_ad", nullable = false, length = 150)
    private String kutuphaneAd;

    @Column(name = "telefon_no", length = 11)
    private String telefonNo;

    @Column(name = "acilis_saati")
    private LocalTime acilisSaati;

    @Column(name = "kapanis_saati")
    private LocalTime kapanisSaati;

    @ManyToOne
    @JoinColumn(name = "il_kodu", nullable = false)
    private Adres adres;

    @OneToMany(mappedBy = "kutuphane")
    private Set<Personel> personeller;

    @OneToMany(mappedBy = "kutuphane")
    private Set<KutuphaneKitap> kutuphaneKitaplar;

    @OneToMany(mappedBy = "kutuphane")
    private Set<KutuphaneOgrenci> kutuphaneOgrenciler;

    public Set<Personel> getPersoneller() {
        return personeller;
    }

    public void setPersoneller(Set<Personel> personeller) {
        this.personeller = personeller;
    }

    public Set<KutuphaneKitap> getKutuphaneKitaplar() {
        return kutuphaneKitaplar;
    }

    public void setKutuphaneKitaplar(Set<KutuphaneKitap> kutuphaneKitaplar) {
        this.kutuphaneKitaplar = kutuphaneKitaplar;
    }

    public UUID getKutuphaneID() {
        return kutuphaneID;
    }

    public void setKutuphaneID(UUID kutuphaneID) {
        this.kutuphaneID = kutuphaneID;
    }

    public String getKutuphaneAd() {
        return kutuphaneAd;
    }

    public void setKutuphaneAd(String kutuphaneAd) {
        this.kutuphaneAd = kutuphaneAd;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public LocalTime getAcilisSaati() {
        return acilisSaati;
    }

    public void setAcilisSaati(LocalTime acilisSaati) {
        this.acilisSaati = acilisSaati;
    }

    public LocalTime getKapanisSaati() {
        return kapanisSaati;
    }

    public void setKapanisSaati(LocalTime kapanisSaati) {
        this.kapanisSaati = kapanisSaati;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Set<KutuphaneOgrenci> getKutuphaneOgrenciler() {
        return kutuphaneOgrenciler;
    }

    public void setKutuphaneOgrenciler(Set<KutuphaneOgrenci> kutuphaneOgrenciler) {
        this.kutuphaneOgrenciler = kutuphaneOgrenciler;
    }

}
