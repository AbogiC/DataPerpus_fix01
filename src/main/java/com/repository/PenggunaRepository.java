package com.repository;

import com.model.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, String> {
    @Query(value = "SELECT p FROM Pengguna p WHERE p.firstName = :nama_depan")
    Optional<Pengguna> findPenggunaByNamaDepan(@PathParam("nama_depan") String nama_depan);
    @Query(value = "SELECT p FROM Pengguna p WHERE p.lastName = :nama_belakang")
    Optional<Pengguna> findPenggunaByNamaBelakang(@PathParam("nama_belakang") String nama_belakang);
    @Query(value = "SELECT p FROM Pengguna p WHERE CONCAT(p.firstName,p.lastName) = :nama_lengkap")
    Optional<Pengguna> findPenggunaByNamaLengkap(@PathParam("nama_lengkap") String nama_lengkap);
    @Query(value = "SELECT p FROM Pengguna p WHERE p.kodePengguna = :kode_pengguna")
    Optional<Pengguna> findPenggunaByKode(@PathParam("kode_pengguna") String kode_pengguna);
    List<Pengguna> findAllByPeranPengguna(String peranPengguna);
}
