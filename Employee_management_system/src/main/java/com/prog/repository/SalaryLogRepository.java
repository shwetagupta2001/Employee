package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.SalaryLog;



public interface SalaryLogRepository extends JpaRepository<SalaryLog, Long>{
	
}
