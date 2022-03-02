package com.cursosdedesarrollo.app.miapp.controllers.rest;

import com.cursosdedesarrollo.app.miapp.domain.Persona;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class ApiRestCrudController {
    // list
    @GetMapping("")
    public List<Persona> apiIndex(){
        List<Persona> listado = new ArrayList<>();
        return listado;
    }
    // insert
    @PostMapping("")
    public Persona apiInsert(@Valid @RequestBody Persona persona){
        return persona;
    }
    // show By Id(Read)
    @GetMapping("/{id}")
    public Persona apiShowById( @PathVariable("id") Long id){
        Persona persona = new Persona();
        persona.setId(id);
        return persona;
    }
    // Update By ID
    @PutMapping("/{id}")
    public Persona apiUpdateById( @PathVariable("id") Long id, @Valid @RequestBody Persona persona){
        persona.setId(id);
        return persona;
    }
    // Delete By ID
    @DeleteMapping("/{id}")
    public Persona apiDeleteById( @PathVariable("id") Long id){
        Persona persona = new Persona();
        persona.setId(id);
        return persona;
    }
}
