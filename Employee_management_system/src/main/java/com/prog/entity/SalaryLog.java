package com.prog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="salary_log")
public class SalaryLog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FullName")
	private String FullName;
	
	@Column(name = "Annual_Salary")
	private Long Annual_Salary;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date = new Date(System.currentTimeMillis());
	
	
	
	public SalaryLog() {
		super();
		
	}

	public SalaryLog(Long id, String fullName, Long annual_Salary, Date date) {
		super();
		this.id = id;
		FullName = fullName;
		Annual_Salary = annual_Salary;
		this.date = date;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public Long getAnnual_Salary() {
		return Annual_Salary;
	}

	public void setAnnual_Salary(Long annual_Salary) {
		Annual_Salary = annual_Salary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
    
}
