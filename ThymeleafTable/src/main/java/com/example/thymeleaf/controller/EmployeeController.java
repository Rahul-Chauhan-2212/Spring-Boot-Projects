package com.example.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleaf.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;

	@PostConstruct
	public void loadData() {

		Employee emp1 = new Employee(1, "Rahul", "Chauhan", "rahul@abc.com");
		Employee emp2 = new Employee(2, "Laxmi", "Chauhan", "laxmi@abc.com");
		Employee emp3 = new Employee(3, "Kiran", "Chauhan", "kiran@abc.com");
		Employee emp4 = new Employee(4, "Pooja", "Chauhan", "pooja@abc.com");

		theEmployees = new ArrayList<>();
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		theEmployees.add(emp4);

	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		
		theModel.addAttribute("employees", theEmployees);
       return "list-employees";
	}

}
