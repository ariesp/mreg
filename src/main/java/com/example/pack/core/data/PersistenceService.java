package com.example.pack.core.data;

import java.util.List;

public interface PersistenceService<T, ID> {
	T saveOrUpdate(T entity);

	void delete(T entity);

	void deleteById(ID id);

	T findById(ID id);

	Long getTotalData();
	
	List<T> getAll();
}