package com.mocking.test_doubles.dummy;

import java.util.List;

public class BookService {

	BookRepository bookRepository;
	EmailService emailService;

	public BookService(BookRepository bookRepository, EmailService emailService) {
		super();
		this.bookRepository = bookRepository;
		this.emailService = emailService;
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	// Other methods with eamil service

}
