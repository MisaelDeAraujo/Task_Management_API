package com.misael.task.management.repositories;

import java.util.List;

import com.misael.task.management.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	boolean existsByTitle(String title);
	List<Task> findByTitle(String title);
	
	
}
