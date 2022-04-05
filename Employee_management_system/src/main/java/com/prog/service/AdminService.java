package com.prog.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.prog.entity.Admin;
import com.prog.entity.AdminRegistrationDto;

public interface AdminService extends UserDetailsService {
	
	
	Admin saveAdmin(AdminRegistrationDto registrationDto);

	

}
