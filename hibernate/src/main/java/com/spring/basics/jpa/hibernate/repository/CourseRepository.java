package com.spring.basics.jpa.hibernate.repository;

import org.springframework.stereotype.Repository;

import com.spring.basics.jpa.hibernate.entity.Course;
import com.spring.basics.jpa.hibernate.entity.Review;


@Repository
public class CourseRepository extends AbstractDAOImpl<Course> {
	
	public CourseRepository() {
		super(Course.class);
	}
	
	public void playWithEntityManager() {
		/*Course course = this.find(10001L);
		course.setName("HUEBR");*/
		
		Course course1 = new Course("Course 1");
		Review review1 = new Review("5", "Good");
		
		entityManager.persist(course1);
		entityManager.persist(review1);
		
	}
	
	public Course findByName(String name) {
		
		return (Course) this.entityManager.createNamedQuery("findByName")
			.setParameter("name", name).getSingleResult();
		
	}
}
