package com.mycrudapp.crudApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycrudapp.crudApi.entity.Employee;
import com.mycrudapp.crudApi.jpaRepo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		// TODO Auto-generated constructor stub
		employeeRepository=theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent())
		{
			theEmployee=result.get();
		}
		else
		{
			throw new RuntimeException("Didn't find any employee with id - "+theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
