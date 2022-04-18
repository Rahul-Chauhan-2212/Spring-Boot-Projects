package com.spring.rest.service;

import java.util.List;

import com.spring.rest.entity.Customer;

public interface CustomerServiceImpl {
	
    public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

}
