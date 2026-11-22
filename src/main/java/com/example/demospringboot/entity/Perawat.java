package com.example.demospringboot.entity;

import jakarta.persistence.Entity;


@Entity
public class Perawat extends Orang {

    
    private String shift;

    public Perawat() {}

    public Perawat(String nama, String shift) {
        super(nama);
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
  
    public void setId(Long id) {
        super.setId(id);
    }
}