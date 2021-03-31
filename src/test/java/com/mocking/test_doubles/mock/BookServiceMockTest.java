package com.mocking.test_doubles.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookServiceMockTest {

	@Test
	void testMock() {

		MockBookRepository mockBookRepository = new MockBookRepository();
		BookService bookService = new BookService(mockBookRepository);

		Book book1 = new Book("100", "Book1", 600);
		Book book2 = new Book("200", "Book2", 300);

		bookService.addBook(book1);
		bookService.addBook(book2);

		mockBookRepository.verify(book2, 1);

	}

	@Test
	public void testMockWithMockito() {

		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);

		Book book1 = new Book("100", "Book1", 600);
		Book book2 = new Book("200", "Book2", 300);

		bookService.addBook(book1); // return
		bookService.addBook(book2); // save method will be called

		// Mockito.verify(bookRepository).save(book1);
		// The save method will not called when we pass book1 (price>500)

		Mockito.verify(bookRepository).save(book2);
		verify(bookRepository, times(0)).save(book1);
		verify(bookRepository, times(1)).save(book2);
	}
}
