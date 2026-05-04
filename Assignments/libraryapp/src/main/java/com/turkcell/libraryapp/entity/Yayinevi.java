package com.turkcell.libraryapp.entity;

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
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "yayinevleri")
public class Yayinevi {
    @Id
    @UuidGenerator()
    @Column(name = "yayinevi_no",nullable = false)
    private UUID yayineviNo;
    
    @Column(name = "yayinevi_ad",nullable = false,length = 100)
    private String yayineviAd;    
    
    @Column(name = "telefon_no",nullable = false,length = 11)
    @Pattern(regexp = "^[0-9]{11}$", message = "Telefon numarasi 11 haneli olmalidir")
    private String telefonNo;

    //ADRES-YAYINEVI ILISKISI (1-Ç)
    @ManyToOne
    @JoinColumn(name = "adres",nullable = false)
    private Adres adres;

    //YAZAR-YAYINEVI ILISKISI (1-Ç)
    @OneToMany(mappedBy = "yayinevi")
    private Set<Yazar> yazarlar;

    //KITAP-YAYINEVI ILISKISI (1-Ç)
    @OneToMany(mappedBy = "yayinevi")
    private Set<Kitap> kitaplar;






    public UUID getYayineviNo() {
        return yayineviNo;
    }

    public void setYayineviNo(UUID yayineviNo) {
        this.yayineviNo = yayineviNo;
    }

    public String getYayineviAd() {
        return yayineviAd;
    }

    public void setYayineviAd(String yayineviAd) {
        this.yayineviAd = yayineviAd;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Set<Yazar> getYazarlar() {
        return yazarlar;
    }

    public void setYazarlar(Set<Yazar> yazarlar) {
        this.yazarlar = yazarlar;
    }

    public Set<Kitap> getKitaplar() {
        return kitaplar;
    }

    public void setKitaplar(Set<Kitap> kitaplar) {
        this.kitaplar = kitaplar;
    }

    
    
    

}
