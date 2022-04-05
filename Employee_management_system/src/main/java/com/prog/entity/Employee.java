package com.prog.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Transactional
@NoArgsConstructor
@Table(name="employees")
public class Employee implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;
	
	@NotEmpty(message = "FirstName can not be empty!!")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotEmpty(message = "LastName can not be empty!!")
	@Column(name = "last_name")
	private String lastName;
	
	@NotEmpty(message = "Gender can not be empty!!")
	@Column(name = "Gender")
	private String Gender;
	
	@Column(name = "email")
	@Email(regexp="^(.+)@(.+)$", message="Invalid email")
	private String email;
	
	@Column(name = "Phone")
	@NotBlank(message="Field should not be empty")
	@Size(min=10,max=10, message="Invalid Phone_no")
	private String Phone;
	
	@Column(name = "DOB")
	@NotEmpty(message = "Date of Birth can not be empty!!")
	private String DOB;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "salary_id")
	private Salary salary;
    
	
	
public Employee() {
		
	}
	public Employee(String firstName, String lastName, String gender, String email, String phone, String dOB, Salary salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.Gender = gender;
		this.email = email;
		this.Phone = phone;
		this.DOB = dOB;
		this.salary = salary;
	}
	

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
    
    
	
	
	

}
