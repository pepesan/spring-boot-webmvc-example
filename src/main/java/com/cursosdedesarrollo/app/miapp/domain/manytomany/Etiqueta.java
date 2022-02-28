package com.cursosdedesarrollo.app.miapp.domain.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Etiqueta")
@Table(name = "ETIQUETAS")
@Data
public class Etiqueta {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Noticia> noticias = new ArrayList<Noticia>();
}
