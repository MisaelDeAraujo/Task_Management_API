package com.misael.task.management.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.misael.task.management.entities.Task;
import com.misael.task.management.entities.dtos.TaskDto;
import com.misael.task.management.exceptions.TaskNotFoundException;
import com.misael.task.management.repositories.TaskRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Service
@Builder
public class TaskService {

	private TaskRepository taskRepository;


	public Task saveNewTask(TaskDto taskDto) {
		Task task = Task.builder().title(taskDto.title()).description(taskDto.description())
				.creationDate(LocalDateTime.now()).status(taskDto.status()).build();
		return taskRepository.save(task);
	}

	public Task updateTaskExisting(Integer id,TaskDto dto){
		Optional<Task> task0 = taskRepository.findById(id);
		if(task0.isEmpty()) {
			throw new TaskNotFoundException();
			}
		var task = task0.get();
		task.setTitle(dto.title());
		task.setDescription(dto.description());
		return taskRepository.save(task);
	}
	
	public List<Task> viewAllTasks(){
		return taskRepository.findAll();
		 
	}
	
	public Optional<Task> findById(Integer id) {
		Optional<Task> task0= taskRepository.findById(id);
		if(task0.isEmpty()){
			throw new TaskNotFoundException();
		}
		
		return taskRepository.findById(id);
	}
	
	public void delete(Integer id) {
		Optional<Task> task = taskRepository.findById(id);
		if(task.isEmpty()) {
			throw new TaskNotFoundException();
		}
		taskRepository.delete(task.get());
	}
}
