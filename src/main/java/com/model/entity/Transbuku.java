package com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transbuku {
    @Id
    @Column(name = "kd_transbuku")
    private String kodeTransbuku;

    @Column(name = "kode_buku")
    private String kodeBuku;

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getKodeTransbuku() {
        return kodeTransbuku;
    }

    public void setKodeTransbuku(String kodeTransbuku) {
        this.kodeTransbuku = kodeTransbuku;
    }
}
