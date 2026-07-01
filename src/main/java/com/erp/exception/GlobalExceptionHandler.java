package com.erp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseException> handleException(ResourceNotFoundException exception){
	
		ResponseException responseException = new ResponseException();
		responseException.setMessage(exception.getMessage());
		responseException.setStatus(HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseException);
		
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationException(
	            MethodArgumentNotValidException ex) {

	        Map<String, String> errors = new HashMap<String, String>();

	        ex.getBindingResult().getFieldErrors().forEach(error -> {
	            errors.put(error.getField(), error.getDefaultMessage());
	        });

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	
	
}
