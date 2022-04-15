package com.prog.service;

import java.util.List;

import com.prog.entity.Employee;
import com.prog.entity.Salary;
import com.prog.entity.SalaryLog;



public interface EmployeeService {
	
	Employee saveEmployee(Employee employee, Salary salary, SalaryLog salaryLog);
	
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Long id);
    //Salary getSalaryById(Long id);
	Employee updateEmployee(Employee employee);
	
}
