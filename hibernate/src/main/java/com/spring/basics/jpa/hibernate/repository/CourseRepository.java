package com.spring.basics.jpa.hibernate.repository;

import org.springframework.stereotype.Repository;

import com.spring.basics.jpa.hibernate.entity.Course;


@Repository
public class CourseRepository extends AbstractDAOImpl<Course> {
	
	public CourseRepository() {
		super(Course.class);
	}
	
	public void playWithEntityManager() {
		Course course = this.find(10001L);
		course.setName("HUEBR");
	}
}
