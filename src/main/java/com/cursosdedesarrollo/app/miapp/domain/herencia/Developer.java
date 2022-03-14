package com.cursosdedesarrollo.app.miapp.domain.herencia;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Developer extends Technician {
    private String expertLanguajes ;
    public Developer(){
        super();
        this.expertLanguajes = "";
    }
}
