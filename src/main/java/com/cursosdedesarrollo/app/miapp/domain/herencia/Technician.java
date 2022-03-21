package com.cursosdedesarrollo.app.miapp.domain.herencia;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Data
@PrimaryKeyJoinColumn(name="employeeId")
public class Technician extends Employee {

    private Integer experienceYears = 0;

    public Technician (){
        super();
        this.experienceYears = 0;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + getId() +
                "name=" + getName() +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
