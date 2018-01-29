package com.spring.basics.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.basics.database.databasedemo.beans.Person;

@Repository
@Transactional
public class JpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("findAllPersons", Person.class);
		return namedQuery.getResultList();
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);// JPA
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public void delete(Person person) {
		entityManager.remove(entityManager.merge(person));
	}
	
}
