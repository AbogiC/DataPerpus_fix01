package com.repository;

import com.model.entity.Rak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public interface RakRepository extends JpaRepository<Rak, String> {
    @Query(value = "select r from Rak r where r.lokasiRak = :rak", nativeQuery = false)
    Optional<Rak> findRakByLokasiRak(@PathParam("rak") String rak);

    List<Rak> findAllByNamaRak(String namaRak);

}
