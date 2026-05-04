package com.turkcell.libraryapp_cqrs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mudurler")
@PrimaryKeyJoinColumn(name = "personel_no")
public class Mudur extends Personel {

    @Column(name = "mudur_maas", nullable = false)
    private double mudurMaas;

    @Column(name = "diploma_alani", nullable = false, length = 100)
    private String diplomaAlani;

    public double getMudurMaas() {
        return mudurMaas;
    }

    public void setMudurMaas(double mudurMaas) {
        this.mudurMaas = mudurMaas;
    }

    public String getDiplomaAlani() {
        return diplomaAlani;
    }

    public void setDiplomaAlani(String diplomaAlani) {
        this.diplomaAlani = diplomaAlani;
    }

    
}