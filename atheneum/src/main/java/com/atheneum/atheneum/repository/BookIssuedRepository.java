package com.atheneum.atheneum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.atheneum.atheneum.pojo.BookIssued;

@RepositoryRestResource(path="bookIssued")
public interface BookIssuedRepository extends JpaRepository<BookIssued, Integer>{

}
