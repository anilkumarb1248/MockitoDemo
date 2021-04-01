package com.mockito.exception_handling;

import java.sql.SQLException;
import java.util.List;

public class BookService {

	BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public int findAllBooksPrice() {
		int totalPrice = 0;
		try {
			List<Book> books = bookRepository.findAllBooks();
			for (Book book : books) {
				totalPrice = totalPrice + book.getPrice();
			}

		} catch (SQLException e) {
			// Logging the exception and our own exception
			throw new DataBaseReadException("No data found");
		}

		return totalPrice;
	}

	public void addBook(Book book) {
		try {
			bookRepository.save(book);

		} catch (SQLException e) {
			// Logging the exception and our own exception
			throw new DataBaseWriteException("No data found");
		}

	}
}
