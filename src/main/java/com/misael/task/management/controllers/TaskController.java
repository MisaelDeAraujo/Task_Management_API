package com.misael.task.management.controllers;

import com.misael.task.management.entities.Task;
import com.misael.task.management.entities.dtos.TaskDto;
import com.misael.task.management.services.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Task> create(@RequestBody @Valid TaskDto taskDto){
		Task task = Task.builder().title(taskDto.title()).description(taskDto.description())
				.creationDate(LocalDateTime.now()).status(taskDto.status()).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveNewTask(task));
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> viewAllTasks(){
		return ResponseEntity.ok().body(taskService.viewAllTasks());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTask(@PathVariable(value="id") Integer id, @RequestBody @Valid TaskDto taskDto){
		Optional<Task> task0 = taskService.findByTaskId(id);
		if(task0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task Not Found");
			}
		var task = task0.get();
		BeanUtils.copyProperties(taskDto, task);
		return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTaskExisting(task));
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> viewByTaskId(@PathVariable Integer id){
		Optional<Task> task0= taskService.findByTaskId(id);
		if(task0.isPresent()){
			var task = task0.get();
			return ResponseEntity.status(HttpStatus.OK).body(task);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task Not Found");
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Integer id){
		Optional<Task> task = taskService.findByTaskId(id);
		if(task.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task Not Found");
		}
		taskService.delete(task.get());
		return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
		
	}
	
}
