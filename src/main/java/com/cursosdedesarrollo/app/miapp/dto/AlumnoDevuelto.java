package com.cursosdedesarrollo.app.miapp.dto;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import lombok.Data;

@Data
public class AlumnoDevuelto {
    private Boolean error;
    private String message;
    private Alumno alumno;
}
