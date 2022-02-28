package com.cursosdedesarrollo.app.miapp.domain.manytoone;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Author")
@Table(name = "AUTORES")
@Data
public class Autor {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> libros = new ArrayList<Libro>();
}
