package com.prog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prog.entity.AdminRegistrationDto;
import com.prog.service.AdminService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private AdminService adminService;

    public RegistrationController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }

    @ModelAttribute("admin")
    public AdminRegistrationDto adminRegistrationDto() {
        return new AdminRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") 
              AdminRegistrationDto registrationDto) {
        adminService.saveAdmin(registrationDto);
        return "redirect:/registration?success";
    }
}
