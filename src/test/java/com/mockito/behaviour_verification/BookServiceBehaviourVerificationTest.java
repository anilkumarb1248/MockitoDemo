package com.mockito.behaviour_verification;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceBehaviourVerificationTest {

	@InjectMocks
	BookService bookService;

	@Mock
	BookRepository bookRepository;

	@Test
	void addBookTest() {

		Book book = new Book("100", "Book1", 400);
		doNothing().when(bookRepository).save(book);
		bookService.addBook(book);
		verify(bookRepository).save(book);
	}

	@Test
	void addBookTest_Save_Not_Called() {
		Book book = new Book("100", "Book1", 600);
		bookService.addBook(book);
		verify(bookRepository, times(0)).save(book);
	}

	@Test
	void addBookTest_Save_Called() {
		Book book = new Book("100", "Book1", 300);
		bookService.addBook(book);
		verify(bookRepository, times(1)).save(book);
	}

	@Test
	void addBookTest_Called_Count() {
		Book book = new Book("100", "Book1", 300);
		bookService.addBook(book);
		bookService.addBook(book);
		verify(bookRepository, times(2)).save(book);
	}

	@Test
	void addBookTest_Save_Not_Called1() {
		Book book = new Book("100", "Book1", 600);
		bookService.addBook(book);
//		verify(bookRepository, times(0)).save(book);
		verify(bookRepository, never()).save(book);
	}

	@Test
	public void updatePriceTest_verify_interactions() {

		Book book = new Book("100", "Book1", 500);
		when(bookRepository.findBook("100")).thenReturn(book);
		bookService.updatePrice("100", 600);
		verify(bookRepository, times(1)).findBook("100");
		verify(bookRepository, times(1)).save(book);

	}

	@Test
	public void updatePriceTest_verify_no_interactions() {

		Book book = new Book("100", "Book1", 500);
//		when(bookRepository.findBook("100")).thenReturn(book);
		// If we wont comment above line, will get "UnnecessaryStubbingException"

//	bookService.updatePrice("100", 600); //NoInteractionsWanted -  If un comment this & above when
		bookService.updatePrice(null, 600);
		// If we pass book id as null it will not call any repository method.
		verifyNoInteractions(bookRepository);
	}

	@Test
	public void updatePriceTest_verify_no_more_interactions() {
		Book book = new Book("100", "Book1", 500);
		when(bookRepository.findBook("100")).thenReturn(book);
		bookService.updatePrice("100", 600);
		verify(bookRepository).findBook("100");
		verify(bookRepository).save(book); // If comment this - NoInteractionsWanted
		verifyNoMoreInteractions(bookRepository);
	}

	@Test
	public void updatePriceTest_oder() {
		Book book = new Book("100", "Book1", 500);
		when(bookRepository.findBook("100")).thenReturn(book);
		bookService.updatePrice("100", 600);

		InOrder inOrder = Mockito.inOrder(bookRepository);
		inOrder.verify(bookRepository).findBook("100");
		inOrder.verify(bookRepository).save(book);

	}

	@Test
	void addBookTest_atLeast_atMost() {
		Book book = new Book("100", "Book1", 300);
		bookService.addBook(book);
		bookService.addBook(book);
		bookService.addBook(book);
//		verify(bookRepository, times(2)).save(book);

		verify(bookRepository, atLeast(2)).save(book);
//		verify(bookRepository, atLeast(4)).save(book); // Wanted *at least* 4 times

		verify(bookRepository, atMost(3)).save(book);
//		verify(bookRepository, atMost(2)).save(book); // Wanted at most 2 times but was 3

		verify(bookRepository, atLeastOnce()).save(book);

//		verify(bookRepository, atMostOnce()).save(book); //MoreThanAllowedActualInvocations

	}

}
