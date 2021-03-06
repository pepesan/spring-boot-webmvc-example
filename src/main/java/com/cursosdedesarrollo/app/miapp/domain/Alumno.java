package com.cursosdedesarrollo.app.miapp.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Entity
//@Entity(name = "Alumnos")
//@Table(name = ""ALUMNOS)
//@NamedNativeQuery(name = "Alumno.findByCosa", query = "SELECT * FROM Alumno WHERE nombre = ?", resultClass = Alumno.class)
public class Alumno {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@Column(name = "ID")
    private Long id;

    @Size(min = 3, max = 20, message = "el nombre debe tener mas de 3 letras y menos de 20.")
    private String nombre;

    private String apellidos;

    @Min(value = 18, message = "el usuario debe tener 18+")
    private  Integer edad;

}
