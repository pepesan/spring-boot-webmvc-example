package com.cursosdedesarrollo.app.miapp.domain.manytomany;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Noticia")
@Table(name = "NOTICIAS")
@Data
public class Noticia {
    @Id
    @GeneratedValue
    private Long id;

    private String titular;
}
