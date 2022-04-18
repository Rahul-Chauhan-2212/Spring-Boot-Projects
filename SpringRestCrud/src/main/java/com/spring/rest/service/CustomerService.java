package com.spring.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.CustomerRepository;
import com.spring.rest.entity.Customer;

@Service
public class CustomerService implements CustomerServiceImpl {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository)
	{
		this.customerRepository=customerRepository;
	}
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Customer> result=customerRepository.findById(theId);
		Customer theCustomer=null;
		if(result.isPresent())
		{
			theCustomer=result.get();
		}
		else
		{
			throw new RuntimeException("Didn't find any customer with id - "+theId);
		}
		
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(theId);
	}
	
	

}
