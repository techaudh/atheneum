package com.atheneum.atheneum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atheneum.atheneum.pojo.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
}