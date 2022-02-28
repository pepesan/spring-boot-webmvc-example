package com.cursosdedesarrollo.app.miapp.repositories.manytoone;

import com.cursosdedesarrollo.app.miapp.domain.manytoone.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
