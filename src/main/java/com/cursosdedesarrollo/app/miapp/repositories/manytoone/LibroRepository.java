package com.cursosdedesarrollo.app.miapp.repositories.manytoone;

import com.cursosdedesarrollo.app.miapp.domain.manytoone.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
}
