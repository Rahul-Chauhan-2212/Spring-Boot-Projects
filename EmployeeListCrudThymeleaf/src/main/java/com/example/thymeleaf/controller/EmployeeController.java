package com.example.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleaf.entity.Employee;
import com.example.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;

	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAllByOrderByLastNameAsc();

		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee theEmployee)
	{
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel)
	{
		
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId)
	{
		employeeService.deleteById(theId);
		return "redirect:/employees/list";

	}
	

}
