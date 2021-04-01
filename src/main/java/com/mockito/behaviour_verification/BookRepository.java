package com.mockito.behaviour_verification;

public interface BookRepository {

	public void save(Book book);

	public Book findBook(String bookId);

}
