package com.misael.task.management.entities.dtos;

import com.misael.task.management.entities.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record TaskDto(
		@NotBlank(message = "title cannot be empty")
		@NotNull(message = "title cannot be null")
		String title,
		@NotBlank(message = "title cannot be empty")
		@NotNull(message = "description cannot be null")
		String description,
		@Enumerated(EnumType.STRING)
        Status status) {

}
