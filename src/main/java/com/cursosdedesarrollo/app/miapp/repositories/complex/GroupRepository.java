package com.cursosdedesarrollo.app.miapp.repositories.complex;

import com.cursosdedesarrollo.app.miapp.domain.complex.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
