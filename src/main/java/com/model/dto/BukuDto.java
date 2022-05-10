package com.model.dto;

public class BukuDto {
    private String idBuku;
    private String judulBuku;
    private String penulisBuku;
    private String penerbitBuku;
    private Integer tahunTerbit;
    private String namaKategori;
    private Integer jumlahBuku;
    private Integer stokBuku;
    private String idRak;
    private String lokasiRak;
    private String status;

    public String getIdBuku() {
        return idBuku;
    }
    public void setIdBuku(String kode) {
        this.idBuku = kode;
    }

    public String getJudulBuku() {
        return judulBuku;
    }
    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulisBuku() {
        return penulisBuku;
    }
    public void setPenulisBuku(String penulisBuku) {
        this.penulisBuku = penulisBuku;
    }

    public String getPenerbitBuku() {
        return penerbitBuku;
    }
    public void setPenerbitBuku(String penerbitBuku) {
        this.penerbitBuku = penerbitBuku;
    }

    public Integer getTahunTerbit() {return tahunTerbit;}
    public void setTahunTerbit(Integer tahunTerbit) {this.tahunTerbit = tahunTerbit;}

    public String getNamaKategori() { return namaKategori; }
    public void setNamaKategori(String namaKategori) { this.namaKategori = namaKategori; }

    public Integer getJumlahBuku() { return jumlahBuku; }
    public void setJumlahBuku(Integer jumlahBuku) { this.jumlahBuku = jumlahBuku; }

    public Integer getStokBuku() {
        return stokBuku;
    }
    public void setStokBuku(Integer stokBuku) { this.stokBuku = stokBuku;}

    public String getIdRak() { return idRak; }
    public void setIdRak(String idRak) { this.idRak = idRak; }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        this.lokasiRak = lokasiRak;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status;}
}
