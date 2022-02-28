package com.cursosdedesarrollo.app.miapp.repositories;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
