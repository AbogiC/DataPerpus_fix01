package com.model.entity;

import javax.persistence.*;

@Entity
@Table (name = "t_denda")
public class Denda {
    @Id
    @Column (name = " kode_denda")
    private String kodeDenda;

    @Column
    private int besarDenda;

    @OneToOne
    @JoinColumn
    private Transaksi kodeTransaksi;

    public String getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(String kodeDenda) {
        this.kodeDenda = kodeDenda;
    }
    public int getBesarDenda() {
        return besarDenda;
    }

    public void setBesarDenda(int besarDenda) {
        this.besarDenda = besarDenda;
    }

    public Transaksi getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(Transaksi kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }
}
