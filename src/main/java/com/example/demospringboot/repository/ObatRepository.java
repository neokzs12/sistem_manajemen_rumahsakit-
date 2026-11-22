package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringboot.entity.Obat;

public interface ObatRepository extends JpaRepository<Obat, Long> {
}
