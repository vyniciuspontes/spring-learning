package com.spring.basics.jpa.hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;

	protected PartTimeEmployee() {

	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [hourlyWage=" + hourlyWage + ", name=" + getName() + ", id=" + getId() + "]";
	}
	
	

}
