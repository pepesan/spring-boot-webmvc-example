package com.cursosdedesarrollo.app.miapp.controllers.herencia;

import com.cursosdedesarrollo.app.miapp.domain.herencia.Developer;
import com.cursosdedesarrollo.app.miapp.repositories.herencia.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    public DeveloperRepository developerRepository;

    @GetMapping()
    public String findAll (Model modelo){
        List<Developer> developers = this.developerRepository.findAll();
        System.out.println(developers);
        modelo.addAttribute("tecnicos", developers);
        return "herencia/developers";
    }
    @GetMapping("/insert")
    public String insertJaveros (Model modelo){
        Developer developer = new Developer();
        developer.setName("Pepe");
        developer.setExperienceYears(10);
        developer.setExpertLanguajes("Java");
        developer = developerRepository.save(developer);
        System.out.println(developer);
        List<Developer> tecnicos = this.developerRepository.findAll();
        System.out.println(tecnicos);
        modelo.addAttribute("tecnicos", tecnicos);
        return "herencia/developers";
    }
}
