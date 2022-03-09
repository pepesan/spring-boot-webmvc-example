package com.cursosdedesarrollo.app.miapp.repositories;

import com.cursosdedesarrollo.app.miapp.domain.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    List<Alumno> findByNombre(String nombre);

    List<Alumno> findByNombreAndApellidos(String nombre, String apellidos);

    @Query("SELECT a FROM Alumno a WHERE a.edad=43")
    Collection<Alumno> findAll43Alumnos();

    @Query("SELECT a FROM Alumno a WHERE a.nombre = ?1 and a.edad = ?2")
    List<Alumno> findAlumnosByOtrasCosas(String nombre, Integer edad);

}
