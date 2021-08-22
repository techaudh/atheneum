package com.atheneum.atheneum.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.atheneum.atheneum.pojo.ErrorResponse;

@ControllerAdvice
public class RestExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(AuthorNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}