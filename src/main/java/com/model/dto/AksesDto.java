package com.model.dto;

import java.util.Date;

public class AksesDto {
    private Long id;
    private Date tanggalAkses;
    private String kodePengguna;
    private String kodeEbook;
    private String idBuku;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTanggalAkses() {
        return tanggalAkses;
    }

    public void setTanggalAkses(Date tanggalAkses) {
        this.tanggalAkses = tanggalAkses;
    }

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public String getKodeEbook() {
        return kodeEbook;
    }

    public void setKodeEbook(String kodeEbook) {
        this.kodeEbook = kodeEbook;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }
}
