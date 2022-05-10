package com.repository;

import com.model.entity.Denda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DendaRepository extends JpaRepository<Denda, String> {

}
