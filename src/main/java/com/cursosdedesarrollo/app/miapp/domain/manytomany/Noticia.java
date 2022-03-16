package com.cursosdedesarrollo.app.miapp.domain.manytomany;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Noticia")
@Table(name = "NOTICIAS")
@Data
public class Noticia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String titular;
}
