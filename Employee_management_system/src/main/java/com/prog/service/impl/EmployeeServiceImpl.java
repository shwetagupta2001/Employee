package com.prog.service.impl;


import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prog.entity.Employee;
import com.prog.entity.Salary;
import com.prog.entity.SalaryLog;
import com.prog.repository.EmployeeRepository;
import com.prog.repository.SalaryRepository;
import com.prog.service.EmployeeService;

@Service
//@Transactional
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
	public Employee saveEmployee(Employee employee, Salary salary, SalaryLog salaryLog) {
		//salaryRepository.save(salary);
		employee.setEmp_id(UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE);
		employee.setSalary(salary);
		Set<SalaryLog> salaryLogSet = employee.getSalaryLog();
		salaryLogSet.add(salaryLog);
		employee.setSalaryLog(salaryLogSet);
		//employee.setSalaryLog((Set<SalaryLog>) salaryLog);
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
	@CachePut(key="#employee.emp_id")
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
