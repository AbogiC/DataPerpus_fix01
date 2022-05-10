package com.repository;

import com.model.entity.Akses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AksesRepository extends JpaRepository<Akses, Long> {
}
