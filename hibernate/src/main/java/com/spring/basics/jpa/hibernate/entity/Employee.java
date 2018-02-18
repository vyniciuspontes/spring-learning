package com.spring.basics.jpa.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorColumn(name = "EmployeeType")
@NamedQueries(@NamedQuery(name = "findAllEmployees", query = "select e from Employee e"))
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
