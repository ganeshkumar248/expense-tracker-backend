package com.expense.tracker.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundEntity(ResourceNotFoundException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
					HttpStatus.NOT_FOUND.value(),
					new Date(),
					ex.getMessage(),
					request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(),
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BadRequestAlertException.class)
	public ResponseEntity<ErrorMessage> badRequestAlertException(BadRequestAlertException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
				HttpStatus.BAD_REQUEST.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ErrorMessage> InvalidFormatException(InvalidFormatException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(
				HttpStatus.BAD_REQUEST.value(), 
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
}

