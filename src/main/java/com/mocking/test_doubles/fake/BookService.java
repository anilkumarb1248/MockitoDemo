package com.mocking.test_doubles.fake;

import java.util.List;

public class BookService {
	
	BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}

}
