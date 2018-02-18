package com.spring.basics.jpa.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

	private BigDecimal salary;

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	protected FullTimeEmployee() {
		// TODO Auto-generated constructor stub
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + ", name=" + getName() + ", id=" + getId() + "]";
	}

}
