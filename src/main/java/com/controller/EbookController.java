package com.controller;

import com.helper.DefaultResponse;
import com.model.dto.EbookDto;
import com.model.entity.Ebook;
import com.repository.EbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ebook")
public class EbookController {
    private final EbookRepository ebookRepository;

    @Autowired
    public EbookController(EbookRepository ebookRepository){
        this.ebookRepository = ebookRepository;
    }

    //melihat list seluruh ebook
    @GetMapping("/listebook")
    public List<EbookDto> getListEbook(){
        List<EbookDto> list = new ArrayList<>();
        for(Ebook e : ebookRepository.findAll()){
            list.add(convertEntitytoDto(e));
        }
        return list;
    }

    //menambahkan ebook
    //jika id ebook sama, maka update
    @PostMapping("/inputebook")
    public DefaultResponse<EbookDto> saveebook(@RequestBody EbookDto ebookDto){
        Ebook ebook = convertDtotoEntity(ebookDto);
        DefaultResponse<EbookDto> response = new DefaultResponse<>();

        //cek data
        Optional<Ebook> optional = ebookRepository.findById(ebookDto.getIdEbook());
        if(optional.isPresent()){
            response.setMessage("Ebook berhasil di update");
        } else {
            ebookRepository.save(ebook);
            response.setMessage("Berhasil menyimpan");
            response.setData(ebookDto);
        }
        return response;
    }

    //mengambil data ebook berdasarkan nama
    @GetMapping("/getbyname/{name}")
    public DefaultResponse<EbookDto> getByName(@PathVariable String name) {
        DefaultResponse<EbookDto> response = new DefaultResponse<>();
        Optional<Ebook> optional = ebookRepository.findEbookByName(name);
        if(optional.isPresent()){
            response.setMessage("Ebook Ditemukan");
            response.setData(convertEntitytoDto(optional.get()));
        } else {
            response.setMessage("Ebook Tidak Ditemukan");
        }
        return response;
    }

    //convert Dto ke entity
    public Ebook convertDtotoEntity(EbookDto dto) {
        Ebook ebook = new Ebook();
        ebook.setIdEbook(dto.getIdEbook());
        ebook.setJudulEbook(dto.getJudulEbook());
        ebook.setPenulisEbook(dto.getPenulisEbook());
        ebook.setPenerbitEbook(dto.getPenerbitEbook());
        ebook.setTahunTerbit(dto.getTahunTerbit());
        ebook.setEdisi(dto.getEdisi());
        ebook.setNoISBN(dto.getNoISBN());
        ebook.setJumlahHalaman(dto.getJumlahHalaman());

        return ebook;
    }

    //convert Entity to Dto
    public EbookDto convertEntitytoDto(Ebook entity) {
        EbookDto dto = new EbookDto();
        dto.setIdEbook(entity.getIdEbook());
        dto.setJudulEbook(entity.getJudulEbook());
        dto.setPenulisEbook(entity.getPenulisEbook());
        dto.setPenerbitEbook(entity.getPenerbitEbook());
        dto.setTahunTerbit(entity.getTahunTerbit());
        dto.setEdisi(entity.getEdisi());
        dto.setNoISBN(entity.getNoISBN());
        dto.setJumlahHalaman(entity.getJumlahHalaman());

        return dto;
    }
}
