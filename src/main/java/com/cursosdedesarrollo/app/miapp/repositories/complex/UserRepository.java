package com.cursosdedesarrollo.app.miapp.repositories.complex;

import com.cursosdedesarrollo.app.miapp.domain.complex.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
