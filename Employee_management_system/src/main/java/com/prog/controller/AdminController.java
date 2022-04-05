package com.prog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.prog.entity.Employee;
import com.prog.entity.Salary;
import com.prog.service.AdminService;
import com.prog.service.EmployeeService;



@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	

	@Autowired
	private EmployeeService employeeService;
	
	//@GetMapping("/")
		//public String home() {
	   // return "index";
		//}
	
	
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }

	
	@GetMapping("/employees")
	public String listofemployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "admin";
	}
	
	@GetMapping("/employees/salary")
	public String listofsalary(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "salary_list";
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		
		// create student object to hold student form data
		Employee employee = new Employee();
		Salary salary= new Salary();
		model.addAttribute("employee", employee);
		model.addAttribute("salary", salary);
		return "create_employee";
		
	}
	
	@PostMapping("/employees/save")
	public String saveStudent(@Valid @ModelAttribute("employee") Employee employee,@Valid @ModelAttribute("salary") Salary salary,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "create_employee";
        } 
        
            
		employeeService.saveEmployee(employee,salary);
		return "redirect:/employees";
		
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("employee") Employee employee,
			//@ModelAttribute("salary") Salary salary,
			Model model) {
		
		
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setEmp_id(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setDOB(employee.getDOB());
		existingEmployee.setPhone(employee.getPhone());
		existingEmployee.setGender(employee.getGender());
		Salary updateSalary = updateSalary(existingEmployee.getSalary(),employee.getSalary());
		existingEmployee.setSalary(updateSalary);
		//existingEmployee.salary.setSal_id(employee.salary.getSal_id());
		
		
		//Employee existingSalary = employeeService.getSalaryById(employee.getSalary());
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";		
	}

	private Salary updateSalary(Salary existingSalary, Salary salaryUpdate) {
		existingSalary.setAnnual_Salary(salaryUpdate.getAnnual_Salary());
		existingSalary.setBasic(salaryUpdate.getBasic());
		existingSalary.setConveyance_Allowance(salaryUpdate.getConveyance_Allowance());
		existingSalary.setHouse_Rent_Allowance(salaryUpdate.getHouse_Rent_Allowance());
		existingSalary.setMedical_Reimbursement(salaryUpdate.getMedical_Reimbursement());
		existingSalary.setPerformance_Incentive(salaryUpdate.getPerformance_Incentive());
		//existingSalary.setSal_id(salaryUpdate.getSal_id());
		existingSalary.setSpecial_Allowance(salaryUpdate.getSpecial_Allowance());
		return existingSalary;
	}
	
	@GetMapping("/employees/show/{id}")
	public String getStudent(@PathVariable Long id, Model model) {
		model.addAttribute("employees", employeeService.getEmployeeById(id));
		return "admin";
	}
	
}

