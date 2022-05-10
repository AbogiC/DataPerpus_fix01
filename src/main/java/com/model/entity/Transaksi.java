package com.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_transaksi")
public class Transaksi {
    @Id
    @Column(name = "kode_transaksi")
    private String kodeTransaksi;

    @ManyToOne
    @JoinColumn(name = "kd_pengguna",nullable = false)
    private Pengguna kodePengguna;

    @ManyToOne
    @JoinColumn(name = "kd_transbuku",nullable = false)
    private Transbuku transbuku;

    @Column(name = "tanggal_pinjam_hari")
    private int hariPinjam;
    @Column(name = "tanggal_pinjam_bulan")
    private int bulanPinjam;
    @Column(name ="tanggal_pinjam_tahun")
    private int tahunPinjam;
    @Column(name = "tanggal_kembali_hari")
    private int harikembali;
    @Column(name = "tanggal_kembali_bulan")
    private int bulanKembali;
    @Column(name = "tanggal_kembali_tahun")
    private int tahunKembali;
    @OneToOne
    @JoinColumn
    private Denda kodeDenda;
    public int getHariPinjam() {
        return hariPinjam;
    }

    public void setHariPinjam(int hariPinjam) {
        this.hariPinjam = hariPinjam;
    }

    public int getBulanPinjam() {
        return bulanPinjam;
    }

    public void setBulanPinjam(int bulanPinjam) {
        this.bulanPinjam = bulanPinjam;
    }

    public int getTahunPinjam() {
        return tahunPinjam;
    }

    public void setTahunPinjam(int tahunPinjam) {
        this.tahunPinjam = tahunPinjam;
    }

    public int getHarikembali() {
        return harikembali;
    }

    public void setHarikembali(int harikembali) {
        this.harikembali = harikembali;
    }

    public int getBulanKembali() {
        return bulanKembali;
    }

    public void setBulanKembali(int bulanKembali) {
        this.bulanKembali = bulanKembali;
    }

    public int getTahunKembali() {
        return tahunKembali;
    }

    public void setTahunKembali(int tahunKembali) {
        this.tahunKembali = tahunKembali;
    }



    public Denda getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(Denda kodeDenda) {
        this.kodeDenda = kodeDenda;
    }

    public Transbuku getTransbuku() {
        return transbuku;
    }

    public void setTransbuku(Transbuku transbuku) {
        this.transbuku = transbuku;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public Pengguna getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(Pengguna kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

}
