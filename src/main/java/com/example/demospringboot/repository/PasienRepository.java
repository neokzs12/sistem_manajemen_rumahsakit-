package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasienRepository extends JpaRepository<Pasien, Long> {
    Pasien findByNama(String id);
}
