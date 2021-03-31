package com.mocking.test_doubles.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class MockBookRepository implements BookRepository {
	private static int calledCount = 0;
	private static Book lastSavedbook = null;

	@Override
	public void save(Book book) {
		calledCount++;
		lastSavedbook = book;
	}

	public void verify(Book book, int times) {
		assertEquals(calledCount, times);
		assertSame(lastSavedbook, book);
	}

}
