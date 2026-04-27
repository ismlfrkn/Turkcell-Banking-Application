package com.turkcell.libraryapplication.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="adresler")
public class Adres {

@Id
@Column(name="il_kodu")
private int ilKodu;

@Column(name="il_ad",nullable = false, length = 50)
private String ilAdi;

@Column(name="ilce_ad",nullable = false, length = 50)
private String ilceAd;

@Column(name="bolge",nullable = false, length = 50)
private String bolge;

@OneToMany(mappedBy = "adres")
private Set<Kutuphane> kutuphaneler;

@OneToMany(mappedBy = "adres")
private Set<Yayinevi> yayinevleri;



public int getIlKodu() {
    return ilKodu;
}

public void setIlKodu(int ilKodu) {
    this.ilKodu = ilKodu;
}

public String getIlAdi() {
    return ilAdi;
}

public void setIlAdi(String ilAdi) {
    this.ilAdi = ilAdi;
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

public Set<Kutuphane> getKutuphaneler() {
    return kutuphaneler;
}

public void setKutuphaneler(Set<Kutuphane> kutuphaneler) {
    this.kutuphaneler = kutuphaneler;
}

public Set<Yayinevi> getYayinevleri() {
    return yayinevleri;
}

public void setYayinevleri(Set<Yayinevi> yayinevleri) {
    this.yayinevleri = yayinevleri;
}

}
