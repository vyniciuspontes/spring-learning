package com.spring.basics.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.basics.database.databasedemo.beans.Person;
import com.spring.basics.database.databasedemo.jdbc.PersonJdbcDao;
import com.spring.basics.database.databasedemo.jpa.JpaRepository;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private PersonJdbcDao personJdbcDao;
	
	@Autowired
	private JpaRepository jpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	/**
	 * CommandLineRunner runs when the application context is ready
	 */
	@Override
	public void run(String... args) throws Exception {
		/*logger.info("Persons -> {}",personJdbcDao.findAll().toString());
		logger.info("Person -> {}",personJdbcDao.findById(10001).toString());
		logger.info("Deleting 10001 -> Number of rows deleted -> {}", personJdbcDao.delete(10001));

		logger.info("Inserting 10004 -> {}", 
				personJdbcDao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		
		logger.info("Update 10003 -> {}", 
				personJdbcDao.update(new Person(10003, "Pieter", "Utrecht", new Date())));*/
		
		Person p = jpaRepository.findById(10001);
		jpaRepository.insert(new Person("Tara", "Berlin", new Date()));
		jpaRepository.update(new Person(10003, "Pieter", "Utrecht", new Date()));
		logger.info("Finding person with JPA -> {}",p);
		logger.info("Finding all persons with JPA -> {}",jpaRepository.findAll());
		jpaRepository.delete(p);
	}
}
