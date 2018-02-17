/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.basics.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author vyniciuspontes
 */
public abstract class AbstractDAOImpl<T> implements AbstractDAO<T>{

	@Autowired
	protected EntityManager entityManager;
	
	public final Class<T> entityClass;

    public AbstractDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
    		entityManager.persist(entity);
    }
    
    @Override
    public void update(T entity) {
    		entityManager.merge(entity);
    }

    @Override
    public void remove(T entity) {
    		entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public T find(Long id) {
    		return entityManager.find(entityClass, id);
    }
}
