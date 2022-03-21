package com.cursosdedesarrollo.app.miapp.repositories.herencia;

import com.cursosdedesarrollo.app.miapp.domain.herencia.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long> {
    @Query("SELECT d FROM Developer d WHERE d.expertLanguajes = ?1")
    List<Developer> findDevelopersByExpertLanguajes(String nombre);
}
