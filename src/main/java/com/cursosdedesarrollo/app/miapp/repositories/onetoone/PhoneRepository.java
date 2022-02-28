package com.cursosdedesarrollo.app.miapp.repositories.onetoone;

import com.cursosdedesarrollo.app.miapp.domain.onetoone.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
