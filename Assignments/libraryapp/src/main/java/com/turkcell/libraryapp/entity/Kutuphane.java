package com.turkcell.libraryapp.entity;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "kutuphaneler")
public class Kutuphane {
    @Id
    @UuidGenerator
    @Column(name = "kutuphane_id", nullable = false)
    private UUID kutuphaneId;

    @Column(name = "kutuphane_ad", nullable = false, length = 50)
    private String kutuphaneAd;

    @Column(name = "telefon_no", nullable = false, length = 11)
    @Pattern(regexp = "^[0-9]{11}$", message = "Telefon numarasi 11 haneli olmalidir")
    private String telefonNo;

    @Column(name = "acilis_saati", nullable = false)
    private LocalTime acilisSaati = LocalTime.of(9, 0);

    @Column(name = "kapanis_saati", nullable = false)
    private LocalTime kapanisSaati = LocalTime.of(18, 0);

    // ADRES-KUTUPHANE ILISKISI (1-Ç)
    @ManyToOne
    @JoinColumn(name = "adres", nullable = false)
    private Adres adres;

    // KUTUPHANE - KUTUPHANE_KITAP ILISKISI
    @OneToMany(mappedBy = "kutuphane", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KutuphaneKitap> kutuphaneKitaplar = new HashSet<>();

    // KUTUPHANE- ORGRENCILER ILISKISI
    @OneToMany(mappedBy = "kutuphane", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KutuphaneOgrenci> kutuphaneOgrenciler = new HashSet<>();

    // KUTUPHANE - PERSONEL ILISKISI
    @OneToMany(mappedBy = "kutuphane")
    private Set<Personel> personeller = new HashSet<>();

    public Set<KutuphaneKitap> getKutuphaneKitaplar() {
        return kutuphaneKitaplar;
    }

    public void setKutuphaneKitaplar(Set<KutuphaneKitap> kutuphaneKitaplar) {
        this.kutuphaneKitaplar = kutuphaneKitaplar;
    }

    public Set<KutuphaneOgrenci> getKutuphaneOgrenciler() {
        return kutuphaneOgrenciler;
    }

    public void setKutuphaneOgrenciler(Set<KutuphaneOgrenci> kutuphaneOgrenciler) {
        this.kutuphaneOgrenciler = kutuphaneOgrenciler;
    }

    public UUID getKutuphaneId() {
        return kutuphaneId;
    }

    public void setKutuphaneId(UUID kutuphaneId) {
        this.kutuphaneId = kutuphaneId;
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

    public Set<Personel> getPersoneller() {
        return personeller;
    }

    public void setPersoneller(Set<Personel> personeller) {
        this.personeller = personeller;
    }

    

}
