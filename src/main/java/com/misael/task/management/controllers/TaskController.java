package com.misael.task.management.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.misael.task.management.entities.Task;
import com.misael.task.management.entities.dtos.TaskDto;
import com.misael.task.management.services.TaskService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Task> create(@RequestBody @Valid TaskDto taskDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveNewTask(taskDto));
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> viewAllTasks(){
		return ResponseEntity.ok().body(taskService.viewAllTasks());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTask(@PathVariable(value="id") Integer id, @RequestBody @Valid TaskDto taskDto){
		return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTaskExisting(id, taskDto));
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> viewByTaskId(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(id);
		
	}
	
}
