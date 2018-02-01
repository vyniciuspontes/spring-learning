package com.spring.basics.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.basics.jpa.hibernate.entity.Course;

@Repository
public class CourseRepository {
	
	@Autowired
	private EntityManager em;
	
	public Course findById(long id) {
		
		return em.find(Course.class, id);
	}
	
}
