package com.misael.task.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.misael.task.management.repositories.TaskRepository;
import com.misael.task.management.services.TaskService;
@SpringBootTest
@ActiveProfiles("test")
public class TaskServiceTest {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskService taskService;



}
