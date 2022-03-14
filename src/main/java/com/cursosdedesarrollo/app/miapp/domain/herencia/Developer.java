package com.cursosdedesarrollo.app.miapp.domain.herencia;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Data
@PrimaryKeyJoinColumn(name="employeeId")
public class Developer extends Technician {
    private String expertLanguajes ;
    public Developer(){
        super();
        this.expertLanguajes = "";
    }

    @Override
    public String toString() {
        return "Developer{" +
                "expertLanguajes='" + expertLanguajes + '\'' +
                ", id=" + getId() +
                ", name=" + getName() +
                '}';
    }
}
