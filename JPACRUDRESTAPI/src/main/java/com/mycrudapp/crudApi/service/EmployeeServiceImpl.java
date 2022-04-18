package com.mycrudapp.crudApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycrudapp.crudApi.dao.EmployeeDAO;
import com.mycrudapp.crudApi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		// TODO Auto-generated constructor stub
		employeeDAO=theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
