package com.prog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Employee;
import com.prog.entity.SalaryLog;
import com.prog.repository.SalaryLogRepository;
import com.prog.service.SalaryLogService;

@Service
public class SalaryLogServiceImpl implements SalaryLogService {
	
	@Autowired
    private SalaryLogRepository salaryLogRepository;
	
	@Override
	public List<SalaryLog> getAllSalaryLog() {
		return salaryLogRepository.findAll();
	}
	
	

}
