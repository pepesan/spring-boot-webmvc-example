package com.cursosdedesarrollo.app.miapp.repositories.complex;

import com.cursosdedesarrollo.app.miapp.domain.complex.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}
