package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringboot.entity.Perawat;

public interface PerawatRepository extends JpaRepository<Perawat, Long> {
}
