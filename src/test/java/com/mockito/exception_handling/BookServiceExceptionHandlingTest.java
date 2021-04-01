package com.mockito.exception_handling;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceExceptionHandlingTest {

	@InjectMocks
	BookService bookService;

	@Mock
	BookRepository bookRepository;

	@Test
	void findAllBooksPriceTest() throws SQLException {

when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
assertThrows(DataBaseReadException.class, () -> bookService.findAllBooksPrice());

	}
	
	@Test
	public void addBookTest() throws SQLException {
		Book book = new Book("100", "Book1", 400);
		//when(bookRepository.save(book)).thenThrow(SQLException.class);
//		The method when(T) in the type Mockito is not applicable for the arguments (void)
		
doThrow(SQLException.class).when(bookRepository).save(book);
assertThrows(DataBaseWriteException.class, () -> bookService.addBook(book));
	}

}
