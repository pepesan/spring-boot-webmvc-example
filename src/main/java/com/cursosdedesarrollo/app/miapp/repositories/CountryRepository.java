package com.cursosdedesarrollo.app.miapp.repositories;

import com.cursosdedesarrollo.app.miapp.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
