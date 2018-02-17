package com.spring.basics.jpa.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;

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
import com.spring.basics.jpa.hibernate.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CourseRepositoryTests {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private EntityManager em;
	
	@Test
	//@Rollback(false)
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	@Test
	public void findByName() {
		Course c = repository.findByName("Spring in 50 Steps");
		
		assertEquals("Spring in 50 Steps", c.getName());
	}
	
	@Test
	public void findAllReviews() {
		Course course = repository.find(10002L);
		List<Review> reviews = course.getReviews();
		logger.info("Reviews -> {}", reviews);
	}
	
	@Test
	public void addReview() {
		Course course = repository.find(10002L);
		Review review = new Review("3", "average course");
		course.addReview(review);
		review.setCourse(course);
		
		em.persist(review);
		
		List<Review> reviews = course.getReviews();
		logger.info("Reviews -> {}", reviews);
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
		
		Course retrieved = repository.find(2L);
		assertNotNull(retrieved);
		assertEquals(2L, retrieved.getId().longValue());
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
