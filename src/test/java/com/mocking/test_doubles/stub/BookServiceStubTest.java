package com.mocking.test_doubles.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class) // JUnit 4
class BookServiceStubTest {
	
//	@Rule
//	public MockitoRule mockitoRule = MockitoJUnit.rule(); // JUnit 4

	@InjectMocks
	BookService bookService;

	@Mock
	BookRepository bookRepository;
	
//	@Before
//	public void beforeEach() {
//		MockitoAnnotations.initMocks(this);
//	} // JUnit 4

	@Test
	void testStub() {

		BookRepository bookRepository = new StupBookRepository();
		BookService bookService = new BookService(bookRepository);

		List<Book> books = bookService.getBooksApplyingDiscount(10, 30);

		assertEquals(2, books.size());
		assertEquals(450, books.get(0).getPrice());
		assertEquals(900, books.get(1).getPrice());

	}

	@Test
	public void testStubWithMockito() {
		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);

		Book book1 = new Book("100", "Book1", 500);
		Book book2 = new Book("200", "Book2", 1000);

		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);

		when(bookRepository.getNewBooks(30)).thenReturn(books);

		List<Book> newBooks = bookService.getBooksApplyingDiscount(10, 30);

		assertEquals(2, newBooks.size());
		assertEquals(450, newBooks.get(0).getPrice());
		assertEquals(900, newBooks.get(1).getPrice());
	}

}
