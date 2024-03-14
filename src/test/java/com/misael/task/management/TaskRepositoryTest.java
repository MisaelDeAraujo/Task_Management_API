package com.misael.task.management;

import com.misael.task.management.entities.Task;
import com.misael.task.management.entities.dtos.TaskDto;
import com.misael.task.management.entities.enums.Status;
import com.misael.task.management.repositories.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class TaskRepositoryTest {
    @Autowired
    TaskRepository taskRepository;
    @Test
    @DisplayName("Should return Task with specified title exists")
    void shouldReturnTaskWithTitleExists(){
        TaskDto data = new TaskDto("title","description",Status.TODO);
        var task = Task.builder().build();
        BeanUtils.copyProperties(data,task);
        taskRepository.save(task);
        List<Task> foundTitle =  this.taskRepository.findByTitle("title");
        assertFalse(foundTitle.isEmpty());

    }
    @Test
    @DisplayName("Should not return Task with specified title does not exists")
    void shouldNotReturnTaskWithTitleExists(){
        TaskDto data = new TaskDto("title","description",Status.TODO);
        var task = Task.builder().build();
        BeanUtils.copyProperties(data,task);
        taskRepository.save(task);
        List<Task> foundTitle =  this.taskRepository.findByTitle("other title");
        assertTrue(foundTitle.isEmpty());

    }
    @Test
    @DisplayName("Should return true with specified title exists")
    void shouldReturnTrueWithTitleExists(){
        TaskDto data = new TaskDto("title","description",Status.TODO);
        var task = Task.builder().build();
        BeanUtils.copyProperties(data,task);
        taskRepository.save(task);
        boolean existsTitle = taskRepository.existsByTitle("title");
        assertTrue(existsTitle);

    }
    @Test
    @DisplayName("Should return false with specified title does not exists")
    void shouldReturnFalseWithTitleDoesNotExists(){
        TaskDto data = new TaskDto("title","description",Status.TODO);
        var task = Task.builder().build();
        BeanUtils.copyProperties(data,task);
        taskRepository.save(task);
        boolean existsTitle = taskRepository.existsByTitle("other title");
        assertFalse(existsTitle);

    }

}
