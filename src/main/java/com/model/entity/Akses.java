package com.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_akses")
public class Akses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAkses;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    @Column(name = "t_tanggal_akses")
    private Date tanggalAkses;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_pengguna", referencedColumnName = "kd_pengguna")
    private Pengguna kodePengguna;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_ebook", referencedColumnName = "id_ebook")
    private Ebook idEbook;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_buku", referencedColumnName = "id_buku")
    private Buku idBuku;

    public Long getIdAkses() {
        return idAkses;
    }

    public void setIdAkses(Long idAkses) {
        this.idAkses = idAkses;
    }

    public Date getTanggalAkses() {
        return tanggalAkses;
    }

    public void setTanggalAkses(Date tanggalAkses) {
        this.tanggalAkses = tanggalAkses;
    }

    public Pengguna getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(Pengguna kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public Ebook getIdEbook() {
        return idEbook;
    }

    public void setIdEbook(Ebook idEbook) {
        this.idEbook = idEbook;
    }

    public Buku getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Buku idBuku) {
        this.idBuku = idBuku;
    }
}
