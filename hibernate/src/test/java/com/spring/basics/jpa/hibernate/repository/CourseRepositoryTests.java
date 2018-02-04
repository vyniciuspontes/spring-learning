package com.spring.basics.jpa.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.basics.jpa.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(rollbackFor=Exception.class)
public class CourseRepositoryTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Test
	//@Rollback(false)
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	@Test
	public void find() {
		Course course = repository.find(10001L);
		assertNotNull(course);
		assertEquals(10001L, course.getId().longValue());
	}
	
	@Test
	public void create() {
		Course course = new Course();
		course.setName("Java EE");
		repository.create(course);
		
		Course retrieved = repository.find(1L);
		assertNotNull(retrieved);
		assertEquals(1L, course.getId().longValue());
	}
	
	@Test
	public void remove() {
		Course course = repository.find(10001L);
		repository.remove(course);
		assertNull(repository.find(10001L));
	}
	
	@Test
	public void update() {
		Course course = repository.find(10001L);
		course.setName("Other Name");
		repository.update(course);
		
		Course foundCourse = repository.find(10001L);
		assertEquals("Other Name", foundCourse.getName());
	}

}
