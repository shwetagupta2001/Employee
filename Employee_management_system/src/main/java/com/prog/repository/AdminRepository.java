package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prog.entity.Admin;



public interface AdminRepository extends JpaRepository<Admin, Long>{
	Admin findByEmail(String email);
}
