package com.mocking.test_doubles.fake;

import java.util.List;

public interface BookRepository {

	public void save(Book book);
	
	public List<Book> findAll();
}
