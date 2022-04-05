package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Employee;
import com.prog.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long>{



}
