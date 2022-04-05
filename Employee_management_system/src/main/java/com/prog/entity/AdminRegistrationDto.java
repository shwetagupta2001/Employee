package com.prog.entity;

public class AdminRegistrationDto {
    private String FullName;
    private String email;
    private String password;

    public AdminRegistrationDto () {

    }

    public AdminRegistrationDto (String FullName, 
         String email, String password) {
        super();
        this.FullName = FullName;
        this.email = email;
        this.password = password;
    }

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
}
