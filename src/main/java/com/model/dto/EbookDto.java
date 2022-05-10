package com.model.dto;

public class EbookDto {
    private String idEbook;
    private String judulEbook;
    private String penulisEbook;
    private String penerbitEbook;
    private Integer tahunTerbit;
    private Integer edisi;
    private Integer noISBN;
    private Integer jumlahHalaman;

    public String getIdEbook() {
        return idEbook;
    }
    public void setIdEbook(String idEbook) {
        this.idEbook = idEbook;
    }

    public String getJudulEbook() {
        return judulEbook;
    }
    public void setJudulEbook(String judulEbook) {
        this.judulEbook = judulEbook;
    }

    public String getPenulisEbook() {
        return penulisEbook;
    }
    public void setPenulisEbook(String penulisEbook) {
        this.penulisEbook = penulisEbook;
    }

    public String getPenerbitEbook() {
        return penerbitEbook;
    }
    public void setPenerbitEbook(String penerbitEbook) {
        this.penerbitEbook = penerbitEbook;
    }

    public Integer getTahunTerbit() {return tahunTerbit;}
    public void setTahunTerbit(Integer tahunTerbit) {this.tahunTerbit = tahunTerbit;}

    public Integer getEdisi() { return edisi; }
    public void setEdisi(Integer edisi) { this.edisi = edisi; }

    public Integer getNoISBN() { return noISBN; }
    public void setNoISBN(Integer noISBN) { this.noISBN = noISBN; }

    public Integer getJumlahHalaman() {
        return jumlahHalaman;
    }
    public void setJumlahHalaman(Integer jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }
}
