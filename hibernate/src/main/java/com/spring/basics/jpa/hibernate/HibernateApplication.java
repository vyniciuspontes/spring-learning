package com.spring.basics.jpa.hibernate;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.spring.basics.jpa.hibernate.entity.FullTimeEmployee;
import com.spring.basics.jpa.hibernate.entity.PartTimeEmployee;
import com.spring.basics.jpa.hibernate.repository.CourseRepository;
import com.spring.basics.jpa.hibernate.repository.EmployeeRepository;
import com.spring.basics.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
@Transactional
public class HibernateApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//studentRepository.playWithTransientState();
		//courseRepository.playWithEntityManager();
		employeeRepository.create(new FullTimeEmployee("Vynicius", new BigDecimal("1400")));
		employeeRepository.create(new PartTimeEmployee("Marcos", new BigDecimal("50")));
		
		logger.info("Employees -> {}",employeeRepository.findAll());
		
		logger.info("Full Time Employee -> {}", (FullTimeEmployee) employeeRepository.find(1L));
	}
	
	
}
