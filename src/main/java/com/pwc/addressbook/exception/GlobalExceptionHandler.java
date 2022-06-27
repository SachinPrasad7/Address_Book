package com.pwc.addressbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoSuchContactExistsException.class)
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleException(NoSuchContactExistsException ex) {
		return new ErrorResponse(ex.getMessage());
	}
}