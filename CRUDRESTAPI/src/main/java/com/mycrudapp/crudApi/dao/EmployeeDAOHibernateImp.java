package com.mycrudapp.crudApi.dao;

import java.util.List;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mycrudapp.crudApi.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> employee=currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = employee.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee=currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
          
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
        
		Query theQuery=currentSession.createQuery("delete from Employee where id=?1");
		
		theQuery.setParameter(1,theId);
		
		theQuery.executeUpdate();
	}
	

}
