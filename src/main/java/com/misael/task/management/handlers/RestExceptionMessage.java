package com.misael.task.management.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
public class RestExceptionMessage {

	private HttpStatus httpStatus;
	
	private String message;

}
