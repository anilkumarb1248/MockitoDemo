package com.mockito.stubbing;

public interface BookRepository {

	public Book findBook(String bookId);

	public void save(Book book);
}
