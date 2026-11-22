package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringboot.entity.Ruangan;

public interface RuanganRepository extends JpaRepository<Ruangan, Long> {
}
