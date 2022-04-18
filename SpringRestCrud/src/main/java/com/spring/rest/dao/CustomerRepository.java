package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
