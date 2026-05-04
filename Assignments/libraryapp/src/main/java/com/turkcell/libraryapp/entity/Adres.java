package com.turkcell.libraryapp.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "adresler")
public class Adres {
    @Id
    @Column(name = "il_kod",nullable = false)
    @Min(value=1,message = "Türkiye için geçerli bir il numarası giriniz.")
    @Max(value=81,message = "Türkiye için geçerli bir il numarası giriniz.")
    private int ilKod;

    @Column(name = "il_ad",nullable = false,length = 50)
    private String ilAd;

    @Column(name = "ilce_ad",nullable = false,length = 50)
    private String ilceAd;

    @Column(name = "bolge",nullable = false,length = 50)
    private String bolge;

    //ADRES-YAYINEVI ILISKISI (1-Ç)
    @OneToMany(mappedBy = "adres")
    private Set<Yayinevi> yayinevleri;

    //ADRES-KUTUPHANE ILISKISI (1-Ç)
    @OneToMany(mappedBy = "adres")
    private Set<Kutuphane> kutuphaneler;








    public int getIlKod() {
        return ilKod;
    }

    public void setIlKod(int ilKod) {
        this.ilKod = ilKod;
    }

    public String getIlAd() {
        return ilAd;
    }

    public void setIlAd(String ilAd) {
        this.ilAd = ilAd;
    }

    public String getIlceAd() {
        return ilceAd;
    }

    public void setIlceAd(String ilceAd) {
        this.ilceAd = ilceAd;
    }

    public String getBolge() {
        return bolge;
    }

    public void setBolge(String bolge) {
        this.bolge = bolge;
    }

    public Set<Yayinevi> getYayinevleri() {
        return yayinevleri;
    }

    public void setYayinevleri(Set<Yayinevi> yayinevleri) {
        this.yayinevleri = yayinevleri;
    }

    public Set<Kutuphane> getKutuphaneler() {
        return kutuphaneler;
    }

    public void setKutuphaneler(Set<Kutuphane> kutuphaneler) {
        this.kutuphaneler = kutuphaneler;
    }



    
}
