package com.mocking.test_doubles.spy;

public class SpyBookRepository implements BookRepository {

	private static int calledCount = 0;

	private static Book lastSavedbook = null;

	@Override
	public void save(Book book) {
		calledCount++;
		lastSavedbook = book;
	}

	public int getCalledCount() {
		return calledCount;
	}

	public Book getLastSavedBook() {
		return lastSavedbook;
	}

}
