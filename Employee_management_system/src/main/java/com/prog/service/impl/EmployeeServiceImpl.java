package com.prog.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prog.entity.Employee;
import com.prog.entity.Salary;

import com.prog.repository.EmployeeRepository;
import com.prog.repository.SalaryRepository;
import com.prog.service.EmployeeService;

@Service
@CacheConfig(cacheNames={"Employees"})
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Autowired
    private SalaryRepository salaryRepository;
     
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		
	}
	
	@Override
	public Employee saveEmployee(Employee employee, Salary salary) {
		//salaryRepository.save(salary);
		employee.setSalary(salary);
		return employeeRepository.save(employee);
		}
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	@Override
	@Cacheable(key="#id")
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}
	
	//@Override
	//public Salary getSalaryById(Long id) {
		//return salaryRepository.findById(id).get();
	//}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
