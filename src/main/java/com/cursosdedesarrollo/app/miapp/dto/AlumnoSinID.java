package com.cursosdedesarrollo.app.miapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class AlumnoSinID {
    @Size(min = 3, max = 20, message = "el nombre debe tener mas de 3 letras y menos de 20.")
    private String nombre;

    private String apellidos;

    @Min(value = 18, message = "el usuario debe tener 18+")
    private  Integer edad;
}
