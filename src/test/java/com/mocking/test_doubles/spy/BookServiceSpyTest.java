package com.mocking.test_doubles.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookServiceSpyTest {

	@Test
	void testSpy() {
		
		SpyBookRepository spyBookRepository = new SpyBookRepository();
		BookService bookService = new BookService(spyBookRepository);

		Book book1 = new Book("100", "Book1", 600);
		Book book2 = new Book("200", "Book2", 300);
		
		bookService.addBook(book1);
		assertEquals(0, spyBookRepository.getCalledCount());
		// The repository save method should not call
		// because the is more than 500
		
		bookService.addBook(book2);
		assertEquals(1, spyBookRepository.getCalledCount());
		assertSame(book2, spyBookRepository.getLastSavedBook());

		
	}
	
	@Test
	public void testMockWithMockito() {

		BookRepository bookRepositorySpy = spy(BookRepository.class);
		BookService bookService = new BookService(bookRepositorySpy);

		Book book1 = new Book("100", "Book1", 600);
		Book book2 = new Book("200", "Book2", 300);

		bookService.addBook(book1); // return
		bookService.addBook(book2); // save method will be called

		// Mockito.verify(bookRepository).save(book1);
		Mockito.verify(bookRepositorySpy).save(book2);
		verify(bookRepositorySpy, times(0)).save(book1);
		verify(bookRepositorySpy, times(1)).save(book2);
	}
	
	

}
