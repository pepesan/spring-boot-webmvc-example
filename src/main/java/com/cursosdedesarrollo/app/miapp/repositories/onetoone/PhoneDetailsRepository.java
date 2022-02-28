package com.cursosdedesarrollo.app.miapp.repositories.onetoone;

import com.cursosdedesarrollo.app.miapp.domain.onetoone.entities.PhoneDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneDetailsRepository extends JpaRepository<PhoneDetails,Long> {
}
