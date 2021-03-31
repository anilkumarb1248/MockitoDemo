package com.mocking.test_doubles.stub;

import java.util.ArrayList;
import java.util.List;

public class StupBookRepository implements BookRepository {

	@Override
	public List<Book> getNewBooks(int days) {
		
		Book book1 = new Book("100", "Book1", 500);
		Book book2 = new Book("200", "Book2", 1000);

		List<Book> bookList = new ArrayList<Book>();
		bookList.add(book1);
		bookList.add(book2);

		return bookList;
	}

}
