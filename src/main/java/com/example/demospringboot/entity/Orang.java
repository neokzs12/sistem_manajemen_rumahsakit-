package com.example.demospringboot.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public abstract class Orang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

  
    protected String nama;

    protected Orang() {}

    public Orang(String nama) {
        this.nama = nama;
    }

    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
