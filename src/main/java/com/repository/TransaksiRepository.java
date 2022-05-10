package com.repository;

import com.model.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
//    List<Transaksi> findAllByPenggunaKodePengguna(String kode);
}
