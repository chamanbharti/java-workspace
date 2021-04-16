package com.junit5.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.model.Book;
import com.service.BookService;

class AssertTrueDemo {

	@Test
	void assertTrueWithNoMessage() {
		BookService bookService = new BookService();
		List<Book> listOfBooks = bookService.books();
		assertTrue(listOfBooks.isEmpty());
	}
	
	@Test
	void assertTrueWithMessage() {
		BookService bookService = new BookService();
		Book book = new Book("1","head first java","wrox");
//		bookService.addBook(book);
		List<Book> listOfBooks = bookService.books();
		assertTrue(listOfBooks.isEmpty(),"list of books is not empty");
	}
	
	@Test
	void assertTrueWithMessageSupplier() {
		BookService bookService = new BookService();
		Book book = new Book("1","head first java","wrox");
//		bookService.addBook(book);
		List<Book> listOfBooks = bookService.books();
		assertTrue(listOfBooks.isEmpty(),() -> "list of books is not empty");
	}

	@Test
	void assertTrueWithBooleanSupplierAndNoMessage() {
		BookService bookService = new BookService();
		Book book = new Book("1","head first java","wrox");
//		bookService.addBook(book);
		List<Book> listOfBooks = bookService.books();
		assertTrue( () -> listOfBooks.isEmpty());
	}
	
	@Test
	void assertTrueWithBooleanSupplierAndMessage() {
		BookService bookService = new BookService();
		Book book = new Book("1","head first java","wrox");
//		bookService.addBook(book);
		List<Book> listOfBooks = bookService.books();
		assertTrue( () -> listOfBooks.isEmpty(), "list of books is not empty");
	}
	
	@Test
	void assertTrueWithBooleanSupplierAndMessageSupplier() {
		BookService bookService = new BookService();
		Book book = new Book("1","head first java","wrox");
//		bookService.addBook(book);
		List<Book> listOfBooks = bookService.books();
		assertTrue( () -> listOfBooks.isEmpty(), () -> "list of books is not empty");
	}

}
