package com.cursosdedesarrollo.app.miapp.controllers;

import com.cursosdedesarrollo.app.miapp.domain.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/form")
public class FormularioController {
    @GetMapping()
    public String lista(Model modelo) {

        Persona persona= new Persona("","",0);

        modelo.addAttribute("persona", persona);
        return "form";

    }
    @PostMapping("/create")
    public ModelAndView createUser(@Valid Persona persona, BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.addObject("persona", persona);
        model.setViewName(result.hasErrors() ? "form" : "personaReady");
        return model;
    }
}
