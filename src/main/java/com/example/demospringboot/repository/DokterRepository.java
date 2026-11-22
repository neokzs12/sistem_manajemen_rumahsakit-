package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringboot.entity.Dokter;

public interface DokterRepository extends JpaRepository<Dokter, Long> {
}
