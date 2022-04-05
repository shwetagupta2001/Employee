package com.prog.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Transactional
@NoArgsConstructor
@Table(name="salary_log")
public class SalaryLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String FullName;
	
	private Long Annual_Salary;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date(System.currentTimeMillis());
	
	

}
