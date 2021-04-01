package com.mockito.behaviour_verification;

public class Book {

	private String bookId;
	private String name;
	private int price;

	public Book(String bookId, String name, int price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.price = price;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
