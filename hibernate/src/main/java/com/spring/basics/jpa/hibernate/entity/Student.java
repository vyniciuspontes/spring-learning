package com.spring.basics.jpa.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="STUDENT_COURSE", 
	//Specifies the foreign key of the owning side of relationship
	joinColumns=@JoinColumn(name="STUDENT_ID"), 
	//Specifies the foreign key of the other side of relationship
	inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> courses = new ArrayList<>();
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
