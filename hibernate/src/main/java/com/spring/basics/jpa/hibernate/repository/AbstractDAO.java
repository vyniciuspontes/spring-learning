package com.spring.basics.jpa.hibernate.repository;

public interface AbstractDAO<T> {
	
	public void create(T entity);
	public T find(Long id);
	public void update(T entity);
	public void remove (T entity);
}
