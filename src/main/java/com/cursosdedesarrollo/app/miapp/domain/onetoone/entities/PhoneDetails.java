package com.cursosdedesarrollo.app.miapp.domain.onetoone.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PhoneDetails")
@Data
public class PhoneDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String provider;

    private String technology;

    private String distributor;


}
