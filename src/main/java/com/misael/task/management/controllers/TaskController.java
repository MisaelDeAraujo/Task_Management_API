package com.misael.task.management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
	
	@PostMapping
	public ResponseEntity<TaskDto> createNewTask(@RequestBody @Valid TaskDto taskDto){
		taskService.saveNewTask(taskDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(taskDto);
	}
	@GetMapping
	public ResponseEntity<List<Task>> viewAllTasks(){
		List<Task> tasks = taskService.viewAllTasks();
		return ResponseEntity.ok().body(tasks);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TaskDto> updateTask(@PathVariable(value="id") Integer id, @RequestBody @Valid TaskDto taskDto){
		taskService.updateTaskExisting(id, taskDto);
		return ResponseEntity.status(HttpStatus.OK).body(taskDto);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Task> viewByTaskId(@PathVariable Integer id){
		Optional<Task> task = taskService.findById(id);	
		return ResponseEntity.status(HttpStatus.OK).body(task.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Integer id){
		taskService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
}
