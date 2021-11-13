package com.obed.helpdesk.resources.exceptions;



import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandError> objectNotFound (ObjectNotFoundException ex, HttpServletRequest request){
		StandError error = new StandError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	
	}
		 
		@ExceptionHandler(DataIntegrityViolationException.class)
		public ResponseEntity<StandError> dataIntegrityViolationException (DataIntegrityViolationException ex, HttpServletRequest request){
			StandError error = new StandError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violacao de dados", ex.getMessage(), request.getRequestURI());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
