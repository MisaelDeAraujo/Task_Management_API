package com.misael.task.management;

import com.misael.task.management.entities.Task;
import com.misael.task.management.entities.enums.Status;
import com.misael.task.management.repositories.TaskRepository;
import com.misael.task.management.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
@ActiveProfiles("test")
public class TaskServiceTest {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskService taskService;
	@Test
	public void shouldGetTaskDoesNotFullOrEmptyFieldTitle() {
		Task task = Task.builder()
				.title("title")
				.description("description")
				.status(Status.TODO)
				.build();
		boolean result = taskService.getTaskFullField(task).isEmpty();
		assertTrue(result);
	}
	@Test
	public void shouldGetTaskFullFieldTitle() {
		Task task = Task.builder()
				.title("title title title title title title title title")
				.description("description")
				.status(Status.TODO)
				.build();
		boolean result = taskService.getTaskFullField(task).isEmpty();
		assertFalse(result);
	}


}
