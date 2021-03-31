package com.mocking.test_doubles.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BookServiceDummyTest {

	@Test
	void testDummy() {

		BookRepository bookRepository = new FakeBookRepository();
		EmailService emailService = new DummyEmailService();
		BookService bookService = new BookService(bookRepository, emailService);

		bookService.addBook(new Book("100", "Book1", 100));
		bookService.addBook(new Book("200", "Book2", 200));

		assertEquals(2, bookService.findAll().size());
	}

	@Test
	public void testDummyWithMockito() {

		BookRepository bookRepository = mock(BookRepository.class);
		EmailService emailService = mock(EmailService.class);
		BookService bookService = new BookService(bookRepository, emailService);

		Book book1 = new Book("100", "Book1", 600);
		Book book2 = new Book("200", "Book2", 300);

		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);

		when(bookRepository.findAll()).thenReturn(books);
		assertEquals(2, bookService.findAll().size());
	}
}
