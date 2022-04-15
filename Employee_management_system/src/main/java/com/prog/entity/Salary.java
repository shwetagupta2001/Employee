package com.prog.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

import javax.validation.constraints.NotNull;



@Entity
@Table(name="salary")
public class Salary implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sal_id;
	
	@NotNull(message = "Basic can not be empty!!")
	@Column(name = "Basic")
	private Long Basic;
	
	@NotNull(message = "House_Rent_Allowance can not be empty!!")
	@Column(name = "House_Rent_Allowance")
	private Long House_Rent_Allowance;
	
	@NotNull(message = "Conveyance_Allowance can not be empty!!")
	@Column(name = "Conveyance_Allowance")
	private Long Conveyance_Allowance;
	
	@NotNull(message = "Medical_Reimbursement can not be empty!!")
	@Column(name = "Medical_Reimbursement")
	private Long Medical_Reimbursement;
	
	@NotNull(message = "Special_Allowance can not be empty!!")
	@Column(name = "Special_Allowance")
	private Long Special_Allowance;
	
	@NotNull(message = "Performance_Incentive can not be empty!!")
	@Column(name = "Performance_Incentive")
	private Long Performance_Incentive;
	
	@NotNull(message = "Long Annual_Salary can not be empty!!")
	@Column(name = "Annual_Salary")
	private Long Annual_Salary;
	
	
	public Salary() {
		
	}

	public Salary(Long basic, Long house_Rent_Allowance,Long conveyance_Allowance, Long medical_Reimbursement, Long special_Allowance,
			Long performance_Incentive, Long annual_Salary, Employee employee) {
		super();
		this.Basic = basic;
		this.House_Rent_Allowance = house_Rent_Allowance;
		this.Conveyance_Allowance = conveyance_Allowance;
		this.Medical_Reimbursement = medical_Reimbursement;
		this.Special_Allowance = special_Allowance;
		this.Performance_Incentive = performance_Incentive;
		this.Annual_Salary = annual_Salary;
		
	}

	public Long getSal_id() {
		return sal_id;
	}

	public void setSal_id(Long sal_id) {
		this.sal_id = sal_id;
	}

	public Long getBasic() {
		return Basic;
	}

	public void setBasic(Long basic) {
		Basic = basic;
	}

	public Long getHouse_Rent_Allowance() {
		return House_Rent_Allowance;
	}

	public void setHouse_Rent_Allowance(Long house_Rent_Allowance) {
		House_Rent_Allowance = house_Rent_Allowance;
	}

	public Long getConveyance_Allowance() {
		return Conveyance_Allowance;
	}

	public void setConveyance_Allowance(Long conveyance_Allowance) {
		Conveyance_Allowance = conveyance_Allowance;
	}

	public Long getMedical_Reimbursement() {
		return Medical_Reimbursement;
	}

	public void setMedical_Reimbursement(Long medical_Reimbursement) {
		Medical_Reimbursement = medical_Reimbursement;
	}

	public Long getSpecial_Allowance() {
		return Special_Allowance;
	}

	public void setSpecial_Allowance(Long special_Allowance) {
		Special_Allowance = special_Allowance;
	}

	public Long getPerformance_Incentive() {
		return Performance_Incentive;
	}

	public void setPerformance_Incentive(Long performance_Incentive) {
		Performance_Incentive = performance_Incentive;
	}

	public Long getAnnual_Salary() {
		return Annual_Salary;
	}

	public void setAnnual_Salary(Long annual_Salary) {
		Annual_Salary = annual_Salary;
	}

	
	
	

}
