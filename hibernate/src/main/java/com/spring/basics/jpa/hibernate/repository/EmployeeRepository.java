package com.spring.basics.jpa.hibernate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.basics.jpa.hibernate.entity.Employee;

@Repository
public class EmployeeRepository extends AbstractDAOImpl<Employee> {

	public EmployeeRepository() {
		super(Employee.class);
	}
	
	public List<Employee> findAll(){
		
		List<Employee> returnData = this.entityManager.createNamedQuery("findAllEmployees", Employee.class).getResultList();
		
		return returnData;
	}
}
