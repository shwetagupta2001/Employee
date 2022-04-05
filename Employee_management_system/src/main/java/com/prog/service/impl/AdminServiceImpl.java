package com.prog.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prog.entity.Admin;
import com.prog.entity.AdminRegistrationDto;
import com.prog.entity.Role;
import com.prog.repository.AdminRepository;
import com.prog.service.AdminService;



@Service
public class AdminServiceImpl implements AdminService {
	
	private AdminRepository adminRepository;
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
		
	}
	
    @Override
    public Admin saveAdmin(AdminRegistrationDto registrationDto) {
        Admin admin = new Admin(registrationDto.getFullName(), 
              registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), 
                 Arrays.asList(new Role("ROLE_USER")));

        return adminRepository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) 
                 throws UsernameNotFoundException {

        Admin admin =adminRepository.findByEmail(username);
        if (admin == null) {
            throw new UsernameNotFoundException
                ("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.
                User(admin.getEmail(), admin.getPassword(),
                mapRolesToAuthorities(admin.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities
                   (Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority
                (role.getName())).collect(Collectors.toList());
    }
   


}
