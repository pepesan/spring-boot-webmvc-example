package com.cursosdedesarrollo.app.miapp.controllers.rest;

import com.cursosdedesarrollo.app.miapp.domain.Persona;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MiRestController {

    @GetMapping()
    public String index(){
        return "";
    }

    @GetMapping("/entero")
    public Integer retInteger(){
        return 2;
    }

    @GetMapping("/persona")
    public Persona retPersona(){
        return new Persona();
    }
}
