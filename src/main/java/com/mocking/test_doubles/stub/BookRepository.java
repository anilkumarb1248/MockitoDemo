package com.mocking.test_doubles.stub;

import java.util.List;

public interface BookRepository {

	//Get books which are published in last days
	public List<Book> getNewBooks(int days);
}
