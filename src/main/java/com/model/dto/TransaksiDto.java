package com.model.dto;

import java.util.Date;

public class TransaksiDto {
    private String kode;
    private int hariPinjam;
    private int bulanPinjam;
    private int tahunPinjam;
    private int hariKembali;
    private int bulanKembali;
    private int tahunKembali;
    private String kodePengguna;
    private String namaPengguna;
    private String peranPengguna;
    private String alamatPengguna;
    private String kodeTransbuku;
    private String kodeBuku;
    private String kodeDenda;
    private int besarDenda;

    public String getKodeTransbuku() {
        return kodeTransbuku;
    }

    public void setKodeTransbuku(String kodeTransbuku) {
        this.kodeTransbuku = kodeTransbuku;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public String getPeranPengguna() {
        return peranPengguna;
    }

    public void setPeranPengguna(String peranPengguna) {
        this.peranPengguna = peranPengguna;
    }

    public String getAlamatPengguna() {
        return alamatPengguna;
    }

    public void setAlamatPengguna(String alamatPengguna) {
        this.alamatPengguna = alamatPengguna;
    }

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

    public int getHariKembali() {
        return hariKembali;
    }

    public void setHariKembali(int hariKembali) {
        this.hariKembali = hariKembali;
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

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

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
}
