package com.mycrudapp.crudApi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycrudapp.crudApi.entity.Employee;

@Repository
public class EmployeeDAOJPAImp implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImp(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// TODO Auto-generated method stub
				
		Query theQuery=entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
				
		Employee theEmployee=entityManager.find(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
          
		Employee dbEmployee=entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		        
		Query theQuery=entityManager.createQuery("delete from Employee where id=?1");
		
		theQuery.setParameter(1,theId);
		
		theQuery.executeUpdate();
	}
	

}
