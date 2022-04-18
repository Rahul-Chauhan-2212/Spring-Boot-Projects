package com.mycrudapp.crudApi.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycrudapp.crudApi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
