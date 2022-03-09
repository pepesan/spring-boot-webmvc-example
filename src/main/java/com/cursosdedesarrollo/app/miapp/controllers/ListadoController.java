package com.cursosdedesarrollo.app.miapp.controllers;

import com.cursosdedesarrollo.app.miapp.domain.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/listado")
public class ListadoController {
    @GetMapping()
    public String lista(Model modelo) {

        Persona p1= new Persona("pedro","perez",20);
        Persona p2= new Persona("ana","gomez",30);
        Persona p3= new Persona("gema","alvarez",40);

        List<Persona> personas= Arrays.asList(p1,p2,p3);
        modelo.addAttribute("personas", personas);
        return "lista";

    }
}
