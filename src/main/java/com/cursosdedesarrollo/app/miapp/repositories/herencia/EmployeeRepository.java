package com.cursosdedesarrollo.app.miapp.repositories.herencia;

import com.cursosdedesarrollo.app.miapp.domain.herencia.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
