package com.cursosdedesarrollo.app.miapp.domain.manytoone;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Libro")
@Table(name = "LIBROS")
@Data
public class Libro {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`TITLE`")
    private String title;
}

