package com.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PenggunaDto {
private String kode;
private String firstName;
private String lastName;
private String peran;
private String jenisKelamin;
private String alamat;
private String kontak;
@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
private Date tanggalDaftar;
@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
private Date tanggalEdit;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Date tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    public Date getTanggalEdit() {
        return tanggalEdit;
    }

    public void setTanggalEdit(Date tanggalEdit) {
        this.tanggalEdit = tanggalEdit;
    }
}
