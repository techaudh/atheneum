package com.atheneum.atheneum.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.atheneum.atheneum.pojo.Book;

import java.util.List;

//need to add here @Repository if you want to use it
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void saveBooks(List<Book> books) {
		for(Book b: books) {
			entityManager.persist(b);
		}
		entityManager.flush();
	}

	@Transactional
	public Book getBook(int bookId) {
		Book book = entityManager.find(Book.class, bookId);
		return book;
	}
	
	@Transactional
	public void saveBook(Book book) {
		entityManager.persist(book);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Book> getBooksBySearchedName(String bookNameSearched){
		Query query = entityManager.createQuery("Select b from Book b where b.name LIKE CONCAT('%',:name,'%')");
		query.setParameter("name", bookNameSearched);
		List<Book> books = query.getResultList();
		return books;
	}
}
