package com.mockito.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {

	public List<Book> findAllBooks() throws SQLException;

	public void save(Book book) throws SQLException;

}
