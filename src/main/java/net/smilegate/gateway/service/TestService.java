package net.smilegate.gateway.service;

import java.util.List;

public interface TestService<T> {
	List<T> getList();
	T get(final String s);
	void post(T obj);
	void put(final String s, T obj);
	void delete(final String s);
}
