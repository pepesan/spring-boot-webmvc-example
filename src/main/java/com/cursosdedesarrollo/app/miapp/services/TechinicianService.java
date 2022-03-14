package com.cursosdedesarrollo.app.miapp.services;

import com.cursosdedesarrollo.app.miapp.domain.herencia.Technician;
import com.cursosdedesarrollo.app.miapp.repositories.herencia.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechinicianService {
    @Autowired
    public TechnicianRepository technicianRepository;

    public List<Technician> findAll(){
        return this.technicianRepository.findAll();
    }

    public Technician save(Technician technician) {
        this.technicianRepository.save(technician);
        System.out.println(technician);
        return technician;
    }
}
