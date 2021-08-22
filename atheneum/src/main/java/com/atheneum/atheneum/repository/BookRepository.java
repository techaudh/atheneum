package com.atheneum.atheneum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atheneum.atheneum.pojo.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByNameContaining(String name);
}