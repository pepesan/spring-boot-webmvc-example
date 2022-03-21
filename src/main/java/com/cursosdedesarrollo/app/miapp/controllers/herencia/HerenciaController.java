package com.cursosdedesarrollo.app.miapp.controllers.herencia;

import com.cursosdedesarrollo.app.miapp.domain.herencia.Technician;
import com.cursosdedesarrollo.app.miapp.services.TechinicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/herencia")
public class HerenciaController {
    @Autowired
    public TechinicianService techinicianService;

    @GetMapping()
    public String getJaveros (Model modelo){
        List<Technician> tecnicos = this.techinicianService.findAll();
        System.out.println(tecnicos);
        modelo.addAttribute("tecnicos", tecnicos);
        return "herencia/listado";
    }
    @GetMapping("/insert")
    public String insertJaveros (Model modelo){
        Technician technician= new Technician();
        technician.setName("Pepe");
        technician.setExperienceYears(10);
        technician = this.techinicianService.save(technician);
        System.out.println(technician);
        List<Technician> tecnicos = this.techinicianService.findAll();
        System.out.println(tecnicos);
        modelo.addAttribute("tecnicos", tecnicos);
        return "herencia/listado";
    }
}
