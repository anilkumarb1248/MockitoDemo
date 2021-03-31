package com.mockito.stubbing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceStubbingTest {

	@InjectMocks
	BookService bookService;

	@Mock
	BookRepository bookRepository;

	@Test
	void calculateTotalCostTest() {

		List<String> bookIds = new ArrayList<String>();
		bookIds.add("100");
		bookIds.add("100");

		Book book1 = new Book("100", "Book1", 500);
		Book book2 = new Book("200", "Book2", 300);

		when(bookRepository.findBook("100")).thenReturn(book1).thenReturn(book1);
//		when(bookRepository.findBook("200")).thenReturn(book2);

//		doReturn(book1).when(bookRepository).findBook("100");
//		doReturn(book2).when(bookRepository).findBook("200");

//		doReturn(book1).when(bookRepository.findBook("100"));
//		doReturn(book2).when(bookRepository.findBook("200")); //Compile time error

		int totalCost = bookService.calculateTotalCost(bookIds);

		assertEquals(1000, totalCost);

	}

@Test
public void testVoidMethod() {
	Book book = new Book("100", "Book1", 500);
	doNothing().when(bookRepository).save(book);
	bookService.save(book);
}

}
