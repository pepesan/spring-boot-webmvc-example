package com.cursosdedesarrollo.app.miapp.domain.herencia;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Inheritance(strategy= InheritanceType.JOINED)
@Data
public class Employee {
    @Id
    @GeneratedValue
    Long id;

    private String nif;

    private String name;

    private String phone;

    private String email;

    public Employee() {
        this.name= "";
        this.email = "";
        this.nif = "";
        this.id =0L;
        this.phone = "";
    }

    public Employee(String name) {
        this.name= name;
        this.email = "";
        this.nif = "";
        this.id =0L;
        this.phone = "";
    }
}
