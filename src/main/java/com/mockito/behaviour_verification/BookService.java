package com.mockito.behaviour_verification;

public class BookService {

	BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book) {
		if (book.getPrice() >= 500) {
			return;
		}
		bookRepository.save(book);
	}

	public void updatePrice(String bookId, int price) {

		if (null == bookId) {
			return;
		}

		Book book = bookRepository.findBook(bookId);
		if (book.getPrice() == price) {
			return;
		}

		book.setPrice(price);
		bookRepository.save(book);
	}
}
