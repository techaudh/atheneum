package com.atheneum.atheneum.repository;

import java.util.List;

import com.atheneum.atheneum.pojo.Book;

public interface BookDao {
	public void saveBooks(List<Book> books);
	public void saveBook(Book book);
	public Book getBook(int bookId);
	public List<Book> getBooksBySearchedName(String bookNameSearched);
}