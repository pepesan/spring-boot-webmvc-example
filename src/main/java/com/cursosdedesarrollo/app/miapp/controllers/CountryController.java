package com.cursosdedesarrollo.app.miapp.controllers;

import com.cursosdedesarrollo.app.miapp.domain.Country;
import com.cursosdedesarrollo.app.miapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {

    private CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @GetMapping()
    public String index (Model modelo){
        List<Country> listado = this.countryRepository.findAll();
        modelo.addAttribute("listado", listado);
        return "country/listado";
    }

    public CountryRepository getCountryRepository(){
        return countryRepository;
    }
    public void setCountryRepository(CountryRepository countryRepository){
        this.countryRepository= countryRepository;
    }



}
