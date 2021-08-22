package com.atheneum.atheneum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atheneum.atheneum.pojo.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer>{
	public Reader findByEmail(String email);
}