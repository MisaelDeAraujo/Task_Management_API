package com.misael.task.management.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class TaskFullFieldException extends RuntimeException{

	private List<String> fields;
	
	public TaskFullFieldException(List<String> fields) {
		super("character limit exceeded in field(s):" + fields);
		this.fields = fields;
	}
	
	public TaskFullFieldException(String message) {
		super(message);
	}

}
