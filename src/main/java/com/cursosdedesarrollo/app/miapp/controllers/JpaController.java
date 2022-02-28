package com.cursosdedesarrollo.app.miapp.controllers;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import com.cursosdedesarrollo.app.miapp.repositories.AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/jpa")
public class JpaController {

    Logger logger = LoggerFactory.getLogger(JpaController.class);
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
        logger.trace("/mvc/insert: actualSize="+actualSize);
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

    @GetMapping("/show/{id}")
    public String insert(Model modelo, @PathVariable("id") Long id) {
        Optional<Alumno> alumno = this.alumnoRepository.findById(id);
        if (alumno.isPresent()){
            modelo.addAttribute("alumno", alumno.get());
        }else{
            modelo.addAttribute("alumno", new Alumno());
        }

        return "showalumno";

    }

    @GetMapping("/update/{id}")
    public String udpate(Model modelo, @PathVariable("id") Long id) {
        Optional<Alumno> alumno = this.alumnoRepository.findById(id);
        if (alumno.isPresent()){
            Alumno alumnoRegistry = alumno.get();
            alumnoRegistry.setEdad(44);
            alumnoRepository.save(alumnoRegistry);
            modelo.addAttribute("alumno", alumnoRegistry);
        }else{
            modelo.addAttribute("alumno", new Alumno());
        }

        return "showalumno";

    }

    @GetMapping("/delete/{id}")
    public String delete(Model modelo, @PathVariable("id") Long id) {
        Optional<Alumno> alumno = this.alumnoRepository.findById(id);
        if (alumno.isPresent()){
            Alumno alumnoRegistry = alumno.get();
            alumnoRepository.delete(alumnoRegistry);
            modelo.addAttribute("alumno", alumnoRegistry);
        }else{
            modelo.addAttribute("alumno", new Alumno());
        }

        return "showalumno";

    }

}
