package com.mocking.test_doubles.fake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;

class BookServiceFakeTest {

	@Test
	public void testFake() {

		BookRepository bookRepository = new FakeBookRepository();
		BookService bookService = new BookService(bookRepository);

		bookService.addBook(new Book("100", "Book1", 100));
		bookService.addBook(new Book("200", "Book2", 200));

		assertEquals(2, bookService.findAll().size());

	}

	@Test
	public void testFakeWithMockito() {

//		BookRepository bookRepository = Mockito.mock(BookRepository.class);
		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);

		Book book1 = new Book("100", "Book1", 600);
		Book book2 = new Book("200", "Book2", 300);

		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);

//		Mockito.when(bookRepository.findAll()).thenReturn(books);
		when(bookRepository.findAll()).thenReturn(books);

		assertEquals(2, bookService.findAll().size());

	}
}
