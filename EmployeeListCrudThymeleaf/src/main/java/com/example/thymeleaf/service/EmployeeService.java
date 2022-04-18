package com.example.thymeleaf.service;

import java.util.List;

import com.example.thymeleaf.entity.Employee;

public interface EmployeeService {
	
public List<Employee> findAllByOrderByLastNameAsc();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
