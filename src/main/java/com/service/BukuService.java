package com.service;

import com.model.entity.Buku;
import com.repository.BukuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BukuService {
    private final BukuRepository bukuRepository;

    public BukuService(BukuRepository bukuRepository) { this.bukuRepository = bukuRepository; }

    public int arsipStatus(String idBuku) { return bukuRepository.arsipBuku(idBuku);}
    public int adaStatus(String idBuku) {return bukuRepository.adaBuku(idBuku);}

//    public Buku updateStok(Buku buku) {
//        Buku entity = bukuRepository.save(buku);
//        entity.setStokBuku();
}

