package net.smilegate.gateway.service;

import java.util.List;

public interface CRUDService<T> {
	List<T> findAll();
	T findOne(final int s);
	void save (final T t);
	void update (final int s, T t);
	void delete (final int s);
}
