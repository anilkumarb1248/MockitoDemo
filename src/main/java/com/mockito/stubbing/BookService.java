package com.mockito.stubbing;

import java.util.List;

public class BookService {

	BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public int calculateTotalCost(List<String> bookIds) {
		int totalCost = 0;

		for (String id : bookIds) {
			Book book = bookRepository.findBook(id);
			totalCost = totalCost + book.getPrice();
		}

		return totalCost;
	}
	
	public void save(Book book) {
		bookRepository.save(book);
	}

}
