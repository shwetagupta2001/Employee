package com.prog.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Admin;
import com.prog.entity.AdminRegistrationDto;
import com.prog.entity.Employee;
import com.prog.entity.Salary;
import com.prog.entity.SalaryLog;
import com.prog.repository.SalaryLogRepository;
import com.prog.service.AdminService;
import com.prog.service.EmployeeService;
import com.prog.service.SalaryLogService;



@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SalaryLogService salaryLogService;
	
	@Autowired
	private SalaryLogRepository salaryLogRepository;
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
	
	
	
	@GetMapping("/employees/salaryLog/{id}")
	public String Updatedsalary(@PathVariable Long id,Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		Set<SalaryLog> salaryLog = employee.getSalaryLog();
		model.addAttribute("salaryLog", salaryLog);
	    return "SalaryLog";
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
	public String saveStudent(@Valid @ModelAttribute("employee") Employee employee,
			@Valid @ModelAttribute("salary") Salary salary,
			//@AuthenticationPrincipal AdminRegistrationDto registrationDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "create_employee";
        } 
        
            
		
		//String FullName = registrationDto.getFullName();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		SalaryLog salaryLog = new SalaryLog();
		salaryLog.setFullName(name);
		salaryLog.setAnnual_Salary(salary.getAnnual_Salary());
		employeeService.saveEmployee(employee,salary,salaryLog);
		return "redirect:/employees";
		
	}
	
	@GetMapping("/employees/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id,
			@ModelAttribute("employee") Employee employee,
			@ModelAttribute("salaryLog") SalaryLog salaryLog,
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		SalaryLog salaryList = new SalaryLog();
		salaryList.setFullName(name);
		salaryList.setAnnual_Salary(existingEmployee.getSalary().getAnnual_Salary());
		Set<SalaryLog> salaryLogSet = employee.getSalaryLog();
		salaryLogSet.add(salaryList);
		existingEmployee.setSalaryLog(salaryLogSet);
		
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

