package com.atheneum.atheneum.exceptionhandler;

public class BookNotFoundException extends RuntimeException{
	
	public static final long serialVersionUID = 1L;
	
	public BookNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public BookNotFoundException(String arg) {
		super(arg);
	}
	
	public BookNotFoundException(Throwable arg) {
		super(arg);
	}
}