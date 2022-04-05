package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Employee save(Employee employee);

}
