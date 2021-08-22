package com.atheneum.atheneum.exceptionhandler;

public class AuthorNotFoundException extends RuntimeException{
	
	public static final long serialVersionUID = 1L;
	
	public AuthorNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public AuthorNotFoundException(String arg) {
		super(arg);
	}
	
	public AuthorNotFoundException(Throwable arg) {
		super(arg);
	}
}