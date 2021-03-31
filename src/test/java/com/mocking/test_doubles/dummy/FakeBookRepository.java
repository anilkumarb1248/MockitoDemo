package com.mocking.test_doubles.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FakeBookRepository implements BookRepository {
	
	//In memory database - HashMap or List
	HashMap<String,Book> bookStore = new HashMap<>();

	@Override
	public void save(Book book) {
		bookStore.put(book.getBookId(), book);

	}

	@Override
	public List<Book> findAll() {
		return new ArrayList<Book>(bookStore.values());
	}

}
