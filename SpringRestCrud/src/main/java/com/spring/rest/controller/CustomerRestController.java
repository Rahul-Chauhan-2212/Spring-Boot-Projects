package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Customer;
import com.spring.rest.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerServiceImpl customerService;
	
	@Autowired
	public CustomerRestController(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}
	
	
	@GetMapping("/customers")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) throws Exception {
		Customer theCustomer = customerService.findById(customerId);
		
		if(theCustomer==null)
		{
			throw new Exception();
		}
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		theCustomer.setId(0);
		customerService.save(theCustomer);
		return theCustomer;
	}
	
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.save(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) throws Exception {
		Customer theCustomer = customerService.findById(customerId);

		if (theCustomer == null) {
			throw new Exception();
		} else {
			customerService.deleteById(customerId);
		}
		return "Customer Deleted";
	}

}
