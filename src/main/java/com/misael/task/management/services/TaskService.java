package com.misael.task.management.services;

import com.misael.task.management.entities.Task;
import com.misael.task.management.exceptions.TaskFieldTitleExistsException;
import com.misael.task.management.exceptions.TaskFullFieldException;
import com.misael.task.management.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Builder
public class TaskService {

	private TaskRepository taskRepository;

	public List<String> getTaskFullField(Task task){
		List<String> fields = new ArrayList<>();
		
		if(task.getTitle().length()>40) {
			fields.add("Title");
		}
		
		if(task.getDescription().length() > 255) {
			fields.add("Description");
		}
		return fields;	
	}
	
	public List<Task> findByTitle(Task task){
		List<Task> fieldTitle = new ArrayList<>();
		if(taskRepository.existsByTitle(task.getTitle())) {
			fieldTitle = taskRepository.findByTitle(task.getTitle());
		}
		return fieldTitle;
	}

	public Task saveNewTask(Task task) {
		List<String> fields = getTaskFullField(task);
		if(!getTaskFullField(task).isEmpty()) {
			throw new TaskFullFieldException(fields);
		}
		else if(!findByTitle(task).isEmpty()) {
			throw new TaskFieldTitleExistsException(findByTitle(task));
		}
		return taskRepository.save(task);
	}

	public Task updateTaskExisting(Task task){
		return taskRepository.save(task);
	}
	
	public List<Task> viewAllTasks(){
		return taskRepository.findAll();
		 
	}
	
	public Optional<Task> findByTaskId(Integer id) {
		return taskRepository.findById(id);
	}
	
	public void delete(Task task) {
		taskRepository.delete(task);
	}
}
