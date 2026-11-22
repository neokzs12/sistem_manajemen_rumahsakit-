package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
public class Ruangan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    private String tipe;

    public Ruangan() {}

    public Ruangan(String tipe) {
        this.tipe = tipe;
    }

    public Long getId() {
        return id;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
