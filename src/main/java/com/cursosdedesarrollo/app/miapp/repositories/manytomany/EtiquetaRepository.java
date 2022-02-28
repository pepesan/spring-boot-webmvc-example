package com.cursosdedesarrollo.app.miapp.repositories.manytomany;

import com.cursosdedesarrollo.app.miapp.domain.manytomany.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta,Long> {
}
