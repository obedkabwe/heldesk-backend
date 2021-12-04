package helpdesk.exceptions;



import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.obed.helpdesk.exceptions.ValidationError;

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
		
		
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<StandError> ValidationErrors (MethodArgumentNotValidException ex, HttpServletRequest request){
			ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Error na validaçao", ex.getMessage() , request.getRequestURI());
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
