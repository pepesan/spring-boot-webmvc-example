package com.cursosdedesarrollo.app.miapp.controllers;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import com.cursosdedesarrollo.app.miapp.repositories.AlumnoRepository;
import com.cursosdedesarrollo.app.miapp.services.AlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
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
        this.alumnos = alumnoRepository.findAll();
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

    @GetMapping("/search/by/{name}")
    public String searchByNombre(Model modelo, @PathVariable("name")String nombre) {
        List<Alumno> listado = this.alumnoRepository.findByNombre(nombre);
        modelo.addAttribute("alumnos", listado);
        return "listadojpa";
    }

    @GetMapping("/search/by/{name}/{apellidos}")
    public String searchByNombreAndApellido(
            Model modelo,
            @PathVariable("name")String nombre,
            @PathVariable("apellidos")String apellidos
    ) {
        List<Alumno> listado = this.alumnoRepository
                .findByNombreAndApellidos(nombre, apellidos);
        modelo.addAttribute("alumnos", listado);
        return "listadojpa";
    }

    @GetMapping("/search")
    public String search(Model modelo) {
        Collection<Alumno> listado = this.alumnoRepository
                .findAll43Alumnos();
        modelo.addAttribute("alumnos", listado);
        return "listadojpa";
    }
    @GetMapping("/searchbypage")
    public String searchFirstByPage(
            Model modelo,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {
        if (page==null){
            page = 0;
        }
        if (size==null){
            size=0;
        }
        PageRequest firstPageWithTwoElements = PageRequest.of(page, size);
        //firstPageWithTwoElements = PageRequest.of(page, size, Sort.by("nombre").descending());
        Page<Alumno> listado = alumnoRepository.findAll(firstPageWithTwoElements);
        modelo.addAttribute("alumnos", listado);
        return "listadojpa";
    }
    @GetMapping("/search/bycosas/{nombre}/{edad}")
    public String searchByCosas(
            Model modelo,
            @PathVariable("nombre")String nombre,
            @PathVariable("edad")Integer edad) {
        Collection<Alumno> listado = this.alumnoRepository
                .findAlumnosByOtrasCosas(nombre,edad);
        modelo.addAttribute("alumnos", listado);
        return "listadojpa";
    }

    @Autowired
    private AlumnoService alumnoService;
    @GetMapping("/search/first/bycosas/{nombre}/{edad}")
    public String searchFirstByCosas(
            Model modelo,
            @PathVariable("nombre")String nombre,
            @PathVariable("edad")Integer edad) {
        Alumno alumno = this.alumnoService.getFirstByCosas(nombre,edad);
        modelo.addAttribute("alumno", alumno);
        return "showalumno";
    }

}
