package com.spring.basics.jpa.hibernate.repository;

import org.springframework.stereotype.Repository;

import com.spring.basics.jpa.hibernate.entity.Passport;
import com.spring.basics.jpa.hibernate.entity.Student;

@Repository
public class StudentRepository extends AbstractDAOImpl<Student> {

	public StudentRepository() {
		super(Student.class);
	}

	/*
	 * For an entity instance to transition from transient to persistent state, to
	 * become managed, requires either a call to the EntityManager#persist() method
	 * or the cre- ation of a reference from an already-persistent instance and
	 * enabled cascading of state for that mapped association.
	 */
	public void playWithTransientState() {

		Passport p = new Passport("novo");
		p.setId(40001L);

		Student s = new Student();
		s.setName("marcos");
		s.setPassport(p);

		this.entityManager.persist(s);
	}
}
