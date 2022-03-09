package com.cursosdedesarrollo.app.miapp.services;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import com.cursosdedesarrollo.app.miapp.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    public Alumno getFirstByCosas(String nombre, Integer edad){
        Collection<Alumno> listado = this.alumnoRepository
                .findAlumnosByOtrasCosas(nombre,edad);
        return (Alumno) listado.toArray()[0];
    }
}
