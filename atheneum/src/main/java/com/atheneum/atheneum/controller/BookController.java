package com.atheneum.atheneum.controller;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atheneum.atheneum.pojo.Author;
import com.atheneum.atheneum.pojo.Book;
import com.atheneum.atheneum.pojo.BookIssued;
import com.atheneum.atheneum.repository.AuthorRepository;
import com.atheneum.atheneum.repository.BookRepository;
import com.atheneum.atheneum.service.BookService;

@RestController()
@RequestMapping("/books")
//@CrossOrigin(origins = "http://localhost:4200")
public class BookController{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/searchBooks")
	public List<Book> doSomething(@RequestParam String nameSearched) {
		return bookRepository.findByNameContaining(nameSearched);
	}
	
	@PostMapping("/issue")
	public BookIssued issue(@RequestBody @Valid BookIssued bookIssued){
		System.out.println(bookIssued);
		BookIssued newBookIssued = bookService.issue(bookIssued);
		System.out.println(newBookIssued);
		return newBookIssued;
	}
	
	@GetMapping("/mergeBookAuthor")
	public Book assignAuthorToBook(@RequestParam Integer bookId, @RequestParam Integer authorId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		Optional<Author> optionalAuthor = authorRepository.findById(authorId);
		Book book = optionalBook.get();
		book.setAuthor(optionalAuthor.get());
		bookRepository.saveAndFlush(book);
		return book;
	}
	
	//don't know keep it for now
	/*@GetMapping("/insertUser")
	public User insertUser() throws Exception {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encodedPassword = bcrypt.encode("password");
		User user = userDao.saveUser(new User("admin@123	", encodedPassword, "ADMIN", true));
		return user;
	}*/
}