package com.example.demospringboot.entity;

import jakarta.persistence.Entity;


@Entity
public class Dokter extends Orang {


    private String spesialis;

    public Dokter() {}

    public Dokter(String nama, String spesialis) {
        super(nama);
        this.spesialis = spesialis;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
}
