package com.hcl.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GloableException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> error(CustomException ex) {
		
		ErrorResponse er = new ErrorResponse();

		er.setMessage(ex.getMessage());

		er.setStatuscode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ErrorResponse>(er, HttpStatus.ALREADY_REPORTED);

	}

}