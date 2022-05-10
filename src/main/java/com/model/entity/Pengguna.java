package com.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_pengguna")

public class Pengguna {
    @Id
    @Column(name="kd_pengguna", length = 25)
    private String kodePengguna;

    @Column(name="nama_depan")
    private String firstName;

    @Column(name = "nama_belakang")
    private String lastName;

    @Column(name="peran")
    private String peranPengguna;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name="alamat")
    private String alamat;

    @Column(name = "kontak", length = 14)
    private String kontak;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    @Column(name = "tanggal_daftar")
    private Date tanggalDaftar;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    @Column(name = "tanggal_edit")
    private Date tanggalEdit;

    @JsonIgnore
    @OneToMany(mappedBy = "kodePengguna")
    private Set<Akses> akses = new HashSet<>();

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
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

    public String getPeranPengguna() {
        return peranPengguna;
    }

    public void setPeranPengguna(String peranPengguna) {
        this.peranPengguna = peranPengguna;
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

    public Set<Akses> getAkses() {
        return akses;
    }

    public void setAkses(Set<Akses> akses) {
        this.akses = akses;
    }

    public Date getTanggalEdit() {
        return tanggalEdit;
    }

    public void setTanggalEdit(Date tanggalEdit) {
        this.tanggalEdit = tanggalEdit;
    }
}
