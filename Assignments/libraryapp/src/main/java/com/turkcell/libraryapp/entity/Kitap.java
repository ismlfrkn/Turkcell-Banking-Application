package com.turkcell.libraryapp.entity;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "kitaplar")
public class Kitap {

    @Id
    @UuidGenerator
    @Column(name = "kitap_id", nullable = false)
    private UUID kitapId;

    @NotBlank(message = "Kitap adı boş olamaz")
    @Column(name = "kitap_ad", nullable = false)
    private String kitapAd;

    @NotBlank(message = "Kitap türü boş olamaz")
    @Column(name = "kitap_tur", nullable = false)
    private String kitapTur;

    @Column(name = "sayfa_sayi", nullable = false)
    @Min(value = 10, message = "Kitap en az 10 sayfa olmalıdır")
    @Max(value = 5000, message = "Çok büyük bir kitap girdiniz")
    private int sayfaSayi;

    @ManyToOne
    @JoinColumn(name = "yayinevi", nullable = false)
    private Yayinevi yayinevi;

    @ManyToOne
    @JoinColumn(name = "yazar", nullable = false)
    private Yazar yazar;

    @OneToMany(mappedBy = "kitap", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KutuphaneKitap> kutuphaneKitaplar;

    public UUID getKitapId() {
        return kitapId;
    }

    public void setKitapId(UUID kitapId) {
        this.kitapId = kitapId;
    }

    public String getKitapAd() {
        return kitapAd;
    }

    public void setKitapAd(String kitapAd) {
        this.kitapAd = kitapAd;
    }

    public String getKitapTur() {
        return kitapTur;
    }

    public void setKitapTur(String kitapTur) {
        this.kitapTur = kitapTur;
    }

    public int getSayfaSayi() {
        return sayfaSayi;
    }

    public void setSayfaSayi(int sayfaSayi) {
        this.sayfaSayi = sayfaSayi;
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

    public Set<KutuphaneKitap> getKutuphaneKitaplar() {
        return kutuphaneKitaplar;
    }

    public void setKutuphaneKitaplar(Set<KutuphaneKitap> kutuphaneKitaplar) {
        this.kutuphaneKitaplar = kutuphaneKitaplar;
    }
}