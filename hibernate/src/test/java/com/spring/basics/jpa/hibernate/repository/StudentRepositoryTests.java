package com.spring.basics.jpa.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.basics.jpa.hibernate.entity.Passport;
import com.spring.basics.jpa.hibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private EntityManager em;

	@Test
	public void playWithEntityManager() {
		// repository.playWithEntityManager();
	}
	
	@Test
	@Transactional
	public void findStudentPassport() {
		Student student = em.find(Student.class,20001L);
		
		logger.info("Student details -> {}", student);
		logger.info("Passport details -> {}", student.getPassport());
		//assertEquals(40001L, passport.getId().longValue());
	}
	
	@Test
	public void findPassportStudent() {
		
		Passport p = em.find(Passport.class, 40001L);
		
		logger.info("Passport details -> {}", p);
		logger.info("Student details -> {}", p.getStudent());
		
	}

	@Test
	public void find() {
		Student Student = repository.find(20001L);
		assertNotNull(Student);
		assertEquals(20001L, Student.getId().longValue());
	}

	@Test
	public void create() {
		Student student = new Student();
		student.setName("Java EE");
		repository.create(student);

		Student retrieved = repository.find(1L);
		assertNotNull(retrieved);
		assertEquals(1L, retrieved.getId().longValue());
	}

	@Test
	public void remove() {
		Student Student = repository.find(20001L);
		repository.remove(Student);
		assertNull(repository.find(20001L));
	}

	@Test
	public void update() {
		Student Student = repository.find(20001L);
		Student.setName("Other Name");
		repository.update(Student);

		Student foundStudent = repository.find(20001L);
		assertEquals("Other Name", foundStudent.getName());
	}

}
