package com.controller;

import org.springframework.web.bind.annotation.*;
import com.helper.DefaultResponse;
import com.model.dto.RakDto;
import com.model.entity.Rak;
import com.repository.RakRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rak")
public class RakController {
    private final RakRepository rakRepository;

    public RakController(RakRepository rakRepository){
        this.rakRepository = rakRepository;
    }

    //melihat list seluruh rak
    @GetMapping("/listrak")
    public List<RakDto> getListRak(){
        List<RakDto> list = new ArrayList<>();
        for(Rak r : rakRepository.findAll()){
            list.add(convertEntitytoDto(r));
        }
        return list;
    }

    //menambahkan rak
    //jika id rak sama, maka update
    @PostMapping("/inputrak")
    public DefaultResponse<RakDto> saverak(@RequestBody RakDto rakDto){
        Rak rak = convertDtotoEntity(rakDto);
        DefaultResponse<RakDto> response = new DefaultResponse<>();

        //cek data
        Optional<Rak> optional = rakRepository.findRakByLokasiRak(rakDto.getLokasiRak());
        Optional<Rak> optional1 = rakRepository.findById(rakDto.getIdRak());
        if(optional.isPresent()){
            response.setMessage("Rak sudah tersedia");
        } else if (optional1.isPresent()){
            rakRepository.save(rak);
            response.setMessage("Berhasil update data");
            response.setData(rakDto);
        } else {
            rakRepository.save(rak);
            response.setMessage("Berhasil menyimpan");
            response.setData(rakDto);
        }
        return response;
    }

    //mengambil data rak berdasarkan lokasi
    @GetMapping("/getbylokasi/{lokasirak}")
    public DefaultResponse<RakDto> getByLokasiRak (@PathVariable String lokasirak) {
        DefaultResponse<RakDto> response = new DefaultResponse<>();
        Optional<Rak> optional = rakRepository.findRakByLokasiRak(lokasirak);
        if(optional.isEmpty()){
            response.setMessage("Rak Tidak Ditemukan");
        } else {
            response.setMessage("Rak Ditemukan");
            response.setData(convertEntitytoDto(optional.get()));
        }
        return response;
    }

    //mengambil data rak berdasarkan nama
    @GetMapping("/getbyname/{name}")
    public List<RakDto> getListbyNama(@PathVariable String name) {
        List<RakDto> list = new ArrayList<>();
        for(Rak r: rakRepository.findAllByNamaRak(name)){
            list.add(convertEntitytoDto(r));
        }
        return list;
    }

    //convert Dto ke entity
    public Rak convertDtotoEntity(RakDto dto) {
        Rak rak = new Rak();
        rak.setIdRak(dto.getIdRak());
        rak.setNamaRak(dto.getNamaRak());
        rak.setLokasiRak(dto.getLokasiRak());
        return rak;
    }

    //convert Entity to Dto
    public RakDto convertEntitytoDto(Rak entity) {
        RakDto dto = new RakDto();
        dto.setIdRak(entity.getIdRak());
        dto.setNamaRak(entity.getNamaRak());
        dto.setLokasiRak(entity.getLokasiRak());
        return dto;
    }
}
