package com.mocking.test_doubles.stub;

import java.util.List;

public class BookService {

	BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getBooksApplyingDiscount(int discount, int days) {
		List<Book> books = bookRepository.getNewBooks(days);

		books.forEach(book -> {
			int price = book.getPrice();
			int discountPrice = (price * discount) / 100;
			int priceAfterDiscount = price - discountPrice;
			book.setPrice(priceAfterDiscount);
		});

		return books;
	}

}
