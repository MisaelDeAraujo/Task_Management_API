package com.misael.task.management.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.misael.task.management.exceptions.TaskNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler{


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail methodArgumentValid (MethodArgumentNotValidException ex) {
		List<String> fieldError = ex.getBindingResult().getFieldErrors().stream()
				.map(FieldError:: getDefaultMessage).collect(Collectors.toList());
		String errorMessage = fieldError.toString();
		return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
	}
	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<String> taskNotFoundException(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("errors, Task Not Found");
	}
	

}
