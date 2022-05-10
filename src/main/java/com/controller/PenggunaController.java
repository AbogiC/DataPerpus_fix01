package com.controller;

import com.helpers.DefaultResponse;
import com.model.dto.AksesDto;
import com.model.dto.PenggunaDto;
import com.model.entity.Akses;
import com.model.entity.Buku;
import com.model.entity.Ebook;
import com.model.entity.Pengguna;
import com.repository.AksesRepository;
import com.repository.BukuRepository;
import com.repository.EbookRepository;
import com.repository.PenggunaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pengguna")
public class PenggunaController {
    final
    EbookRepository repoEbook;
    final
    PenggunaRepository repoPengguna;
    final
    AksesRepository repoAkses;
    final BukuRepository repoBuku;

    public PenggunaController(EbookRepository repoEbook, PenggunaRepository repoPengguna, AksesRepository repoAkses, BukuRepository repoBuku) {
        this.repoEbook = repoEbook;
        this.repoPengguna = repoPengguna;
        this.repoAkses = repoAkses;
        this.repoBuku = repoBuku;
    }

    @GetMapping
    public List<PenggunaDto> getPengguna(){
        List<Pengguna> listPengguna = repoPengguna.findAll();
        return listPengguna.stream().map(this::convertToDto1).collect(Collectors.toList());
    }
    @GetMapping("/aksesnama/{namaLengkap}")
    public DefaultResponse<PenggunaDto> getByfullName(@PathVariable String namaLengkap){
        DefaultResponse<PenggunaDto> respon = new DefaultResponse<>();
        Optional<Pengguna> nama_lengkap = repoPengguna.findPenggunaByNamaLengkap(namaLengkap);
        if(nama_lengkap.isPresent()){
            respon.setMessage("Nama Ditemukan");
            respon.setData(convertToDto1(nama_lengkap.get()));
        } else{
            respon.setMessage("Nama Tidak Ditemukan");
        }
        return respon;
    }
    @GetMapping("/dataperan/{peranPengguna}")
    public List<PenggunaDto> getByPeran(@PathVariable String peranPengguna){
        List<Pengguna> listPengguna = repoPengguna.findAllByPeranPengguna(peranPengguna);
        return listPengguna.stream().map(this::convertToDto1).collect(Collectors.toList());
    }
    @PostMapping("/daftar")
    public DefaultResponse<PenggunaDto> insert(@RequestBody PenggunaDto dto){
        Pengguna entity = convertToEntity1(dto);
        DefaultResponse<PenggunaDto> masukan = new DefaultResponse<>();

        Optional<Pengguna> namaDepan = repoPengguna.findPenggunaByNamaDepan(dto.getFirstName());
        Optional<Pengguna> namaBelakang = repoPengguna.findPenggunaByNamaBelakang(dto.getLastName());
        if(namaDepan.isPresent() && namaBelakang.isPresent()){
            masukan.setMessage("Nama sudah tersedia");
        } else{
            repoPengguna.save(entity);
            masukan.setMessage("Berhasil menyimpan");
            masukan.setData(dto);
        }
        return masukan;
    }
    @PostMapping("/edit/{kodePengguna}")
    public DefaultResponse<PenggunaDto> edit(@RequestBody PenggunaDto dto, @PathVariable String kodePengguna){
        Pengguna entity = convertToEntity2(dto);
        DefaultResponse<PenggunaDto> masukan = new DefaultResponse<>();

        Optional<Pengguna> kode_pengguna = repoPengguna.findPenggunaByKode(kodePengguna);
        if(kode_pengguna.isPresent()){
            repoPengguna.save(entity);
            masukan.setMessage("Data diri berhasil diperbaharui");
            masukan.setData(dto);
        } else{
            masukan.setMessage("Nama tidak ditemukan");
        }
        return masukan;
    }
    @PostMapping("/akses_ebook/input")
    public DefaultResponse<AksesDto> insertebook(@RequestBody AksesDto dto){
        Akses entity = convertToEntity3(dto);
        DefaultResponse<AksesDto> masukan = new DefaultResponse<>();

        Optional<Pengguna> kode_pengguna = repoPengguna.findPenggunaByKode(dto.getKodePengguna());
        Optional<Ebook> id_ebook = repoEbook.findEbookById(dto.getKodeEbook());
        if(kode_pengguna.isPresent() && id_ebook.isPresent()){
            repoAkses.save(entity);
            masukan.setData(dto);
            masukan.setMessage("Berhasil menyimpan");
        } else if(kode_pengguna.isPresent()){
            masukan.setMessage("Kode Pengguna ditemukan, Ebook tidak ditemukan.");
        } else if(id_ebook.isPresent()){
            masukan.setMessage("Ebook ditemukan, Kode Pengguna tidak ditemukan.");
        }
        return masukan;
    }

    @PostMapping("/akses_buku/input")
    public DefaultResponse<AksesDto> insertbuku(@RequestBody AksesDto dto){
        Akses entity = convertToEntity3(dto);
        DefaultResponse<AksesDto> masukan = new DefaultResponse<>();

        Optional<Pengguna> kode_pengguna = repoPengguna.findPenggunaByKode(dto.getKodePengguna());
        Optional<Buku> id_buku = repoBuku.findBukuById(dto.getIdBuku());
        if(kode_pengguna.isPresent() && id_buku.isPresent()){
            repoAkses.save(entity);
            masukan.setData(dto);
            masukan.setMessage("Berhasil menyimpan");
        } else if(kode_pengguna.isPresent()){
            masukan.setMessage("Kode Pengguna ditemukan, Buku tidak ditemukan.");
        } else if(id_buku.isPresent()){
            masukan.setMessage("Buku ditemukan, Kode Pengguna tidak ditemukan.");
        }
        return masukan;
    }

//    @PutMapping("/{id}/kodepengguna/{kodePengguna}/ebook/{idEbook}")
//    Akses dataAksesPenggunaEbook(
//            @PathVariable Long id,
//            @PathVariable String idEbook,
//            @PathVariable String kodePengguna
//    ){
//        Akses akses = repoAkses.findById(id).get();
//        Pengguna pengguna = repoPengguna.findPenggunaByKode(kodePengguna).get();
//        Ebook ebook = repoEbook.findEbookById(idEbook).get();
//        akses.setTanggalAkses(new Date());
//        akses.setIdEbook(ebook);
//        akses.setKodePengguna(pengguna);
//        return repoAkses.save(akses);
//    }
    @GetMapping("/dataakses")
    List<Akses> getDataAkses(){ return repoAkses.findAll(); }

    private PenggunaDto convertToDto1(Pengguna entity){
        PenggunaDto dto = new PenggunaDto();
        dto.setKode(entity.getKodePengguna());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPeran(entity.getPeranPengguna());
        dto.setJenisKelamin(entity.getJenisKelamin());
        dto.setAlamat(entity.getAlamat());
        dto.setKontak(entity.getKontak());
        dto.setTanggalDaftar(entity.getTanggalDaftar());
        return dto;
    }
    private Pengguna convertToEntity1(PenggunaDto dto){
        Pengguna entity = new Pengguna();
        entity.setKodePengguna(dto.getKode());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPeranPengguna(dto.getPeran());
        entity.setJenisKelamin(dto.getJenisKelamin());
        entity.setAlamat(dto.getAlamat());
        entity.setKontak(dto.getKontak());
        entity.setTanggalDaftar(new Date());
        return entity;
    }
    private Pengguna convertToEntity2(PenggunaDto dto){
        Pengguna entity = new Pengguna();
        entity.setKodePengguna(dto.getKode());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPeranPengguna(dto.getPeran());
        entity.setJenisKelamin(dto.getJenisKelamin());
        entity.setAlamat(dto.getAlamat());
        entity.setKontak(dto.getKontak());
        entity.setTanggalDaftar(dto.getTanggalDaftar());
        entity.setTanggalEdit(new Date());
        return entity;
    }
    private Akses convertToEntity3(AksesDto dto){
        Akses entity = new Akses();
        entity.setTanggalAkses(new Date());
        if(repoPengguna.findPenggunaByKode(dto.getKodePengguna()).isPresent()){
            Pengguna pengguna = repoPengguna.findPenggunaByKode(dto.getKodePengguna()).get();
            entity.setKodePengguna(pengguna);
        }
        if(repoEbook.findEbookById(dto.getKodeEbook()).isPresent()){
            Ebook ebook = repoEbook.findEbookById(dto.getKodeEbook()).get();
            entity.setIdEbook(ebook);
        }
        if(repoBuku.findBukuById(dto.getIdBuku()).isPresent()){
            Buku buku = repoBuku.findBukuById(dto.getIdBuku()).get();
            entity.setIdBuku(buku);
        }
        return entity;
    }
}
