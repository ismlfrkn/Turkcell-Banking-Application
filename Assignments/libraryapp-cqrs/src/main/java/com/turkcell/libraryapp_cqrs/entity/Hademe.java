package com.turkcell.libraryapp_cqrs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hademeler")
@PrimaryKeyJoinColumn(name = "personel_no")
public class Hademe extends Personel {

    @Column(name = "hademe_maas", nullable = false)
    private double hademeMaas;

    @Column(name = "vardiya_turu", nullable = false, length = 50)
    private String vardiyaTuru;

    @Column(name = "temizlik_bolgesi", nullable = false, length = 100)
    private String temizlikBolgesi;

    public double getHademeMaas() {
        return hademeMaas;
    }

    public void setHademeMaas(double hademeMaas) {
        this.hademeMaas = hademeMaas;
    }

    public String getVardiyaTuru() {
        return vardiyaTuru;
    }

    public void setVardiyaTuru(String vardiyaTuru) {
        this.vardiyaTuru = vardiyaTuru;
    }

    public String getTemizlikBolgesi() {
        return temizlikBolgesi;
    }

    public void setTemizlikBolgesi(String temizlikBolgesi) {
        this.temizlikBolgesi = temizlikBolgesi;
    }

    
}