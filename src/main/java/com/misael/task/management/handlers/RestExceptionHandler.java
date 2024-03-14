package com.misael.task.management.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.misael.task.management.entities.Task;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.misael.task.management.exceptions.TaskFieldTitleExistsException;
import com.misael.task.management.exceptions.TaskFullFieldException;

@RestControllerAdvice
public class RestExceptionHandler{

	@ExceptionHandler(TaskFullFieldException.class)
	public ResponseEntity<RestExceptionMessage> taskFullOrEmptyField(TaskFullFieldException ex){
		List<String> fields = ex.getFields();
		RestExceptionMessage restExceptionMessage = RestExceptionMessage.builder()
				.httpStatus(HttpStatus.BAD_REQUEST)
				.message("Character limit exceeded or empty in field(s):"+ fields)
				.build();
		return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body(restExceptionMessage);

	}

	@ExceptionHandler(TaskFieldTitleExistsException.class)
	public ResponseEntity<RestExceptionMessage> taskFieldTitleExists(TaskFieldTitleExistsException ex){
		List<Task> taskTitle = ex.getTaskTitle();
		RestExceptionMessage restExceptionMessage = RestExceptionMessage.builder()
				.httpStatus(HttpStatus.BAD_REQUEST)
				.message("A task with the same title already exists:"+ taskTitle)
				.build();
		return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body(restExceptionMessage);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Map<String, List<String>>> MethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors()
				.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	private Map<String, List<String>> getErrorsMap(List<String> errors) {
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}

}
