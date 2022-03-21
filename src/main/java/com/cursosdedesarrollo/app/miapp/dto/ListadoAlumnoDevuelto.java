package com.cursosdedesarrollo.app.miapp.dto;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import lombok.Data;

import java.util.List;

@Data
public class ListadoAlumnoDevuelto {
    private Boolean error;
    private String message;
    private List<Alumno> alumnos;
}
