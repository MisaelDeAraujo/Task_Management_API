package com.misael.task.management.exceptions;

import java.util.List;

import com.misael.task.management.entities.Task;
import lombok.Getter;

@Getter
public class TaskFieldTitleExistsException extends RuntimeException{

	private final List<Task> taskTitle;
	
	public TaskFieldTitleExistsException(List<Task> taskTitle) {
		super("title exists:" + taskTitle);
		this.taskTitle = taskTitle;
	}


}
