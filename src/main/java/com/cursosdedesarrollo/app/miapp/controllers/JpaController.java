package com.cursosdedesarrollo.app.miapp.controllers;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import com.cursosdedesarrollo.app.miapp.domain.Persona;
import com.cursosdedesarrollo.app.miapp.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/jpa")
public class JpaController {
    List<Alumno> alumnos;
    @Autowired
    private AlumnoRepository alumnoRepository;

    JpaController(){
        this.alumnos = new ArrayList<>();
    }

    @GetMapping()
    public String lista(Model modelo) {
        List<Alumno> alumnos = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", alumnos);
        return "listadojpa";

    }
    @GetMapping("/insert")
    public String insert(Model modelo) {
        Integer actualSize= alumnoRepository.findAll().size();
        System.out.println("/mvc/insert: actualSize="+actualSize);
        if ( actualSize.equals(0)){
            Alumno alumno = new Alumno();
            alumno.setNombre("Pepe");
            alumno.setApellidos("San");
            alumno.setEdad(43);
            alumnoRepository.save(alumno);
            System.out.println("/mvc/insert: alumno="+alumno);
        }
        List<Alumno> alumnos = alumnoRepository.findAll();
        modelo.addAttribute("alumnos", alumnos);
        return "listadojpa";

    }

}
