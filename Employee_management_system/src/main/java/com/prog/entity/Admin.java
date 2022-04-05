package com.prog.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name="admin", uniqueConstraints = @UniqueConstraint
(columnNames = "email"))
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "FullName can not be empty!!")
	@Column(name = "FullName", nullable = false)
	private String FullName;
	
	@Column(name = "email")
	@Email(regexp="^(.+)@(.+)$", message="Invalid email")
	private String email;
	
	@NotEmpty(message = "Please enter Password!!")
	@Column(name = "password", nullable = false)
	private String password;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn
    (name = "user_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id", 
    referencedColumnName = "id"))

    private Collection<Role> roles;
	
    public Admin() {
		
	}
	
	public Admin(String FullName,String email, String password, Collection<Role> roles) {
		super();
		this.FullName = FullName;
		this.email = email;
		this.password  = password ;
		this.roles = roles;
		
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	
	
}
