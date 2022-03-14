package com.cursosdedesarrollo.app.miapp.domain.herencia;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Technician extends Employee {

    private Integer experienceYears = 0;

    public Technician (){
        super();
        this.experienceYears = 0;
    }

}
