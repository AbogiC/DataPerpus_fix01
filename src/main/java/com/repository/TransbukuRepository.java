package com.repository;

import com.model.entity.Transbuku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransbukuRepository extends JpaRepository<Transbuku, String> {
}
