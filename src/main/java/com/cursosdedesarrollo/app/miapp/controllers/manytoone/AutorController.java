package com.cursosdedesarrollo.app.miapp.controllers.manytoone;

import com.cursosdedesarrollo.app.miapp.domain.manytoone.Autor;
import com.cursosdedesarrollo.app.miapp.repositories.manytoone.AutorRepository;
import com.cursosdedesarrollo.app.miapp.repositories.manytoone.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/autores")
public class AutorController {
    Logger logger = LoggerFactory.getLogger(AutorController.class);
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;
    @GetMapping()
    public String lista(Model modelo) {
        List<Autor> autores = autorRepository.findAll();
        modelo.addAttribute("autores", autores);
        return "autores/listado";

    }
    /*
    @GetMapping("/insert")
    public String insert(Model modelo) {
        Integer actualSize= autorRepository.findAll().size();
        logger.trace("/mvc/insert: actualSize="+actualSize);
        if ( actualSize.equals(0)){

            Autor autor = new Autor();
            autor.setNombre("Terry Pratchett");
            /*
            PhoneDetails phoneDetails = new PhoneDetails();
            phoneDetails.setProvider("VodaPhone");
            phoneDetailsRepository.save(phoneDetails);
            phone.setDetails(phoneDetails);


            autorRepository.save(autor);
            System.out.println("/mvc/insert: autor="+autor);
        }
        List<Phone> listado = autorRepository.findAll();
        modelo.addAttribute("autores", listado);
        return "autores/listado";

    }
    */

}
