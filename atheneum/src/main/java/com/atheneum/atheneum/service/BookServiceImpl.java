package com.atheneum.atheneum.service;

import org.hibernate.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atheneum.atheneum.pojo.Book;
import com.atheneum.atheneum.pojo.BookIssued;
import com.atheneum.atheneum.pojo.Reader;
import com.atheneum.atheneum.repository.BookIssuedRepository;
import com.atheneum.atheneum.repository.BookRepository;
import com.atheneum.atheneum.repository.ReaderRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookDao;
	
	@Autowired
	private ReaderRepository readerDao;
	
	@Autowired
	private BookIssuedRepository bookIssuedDao;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public BookIssued issue(BookIssued bookIssued) {
		// TODO Auto-generated method stub
		return null;
	}
}