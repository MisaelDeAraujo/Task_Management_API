package com.misael.task.management.entities.dtos;

import org.hibernate.validator.constraints.Length;

import com.misael.task.management.entities.enums.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskDto(
		@NotBlank(message = "title cannot be empty")
		@NotNull(message = "title cannot be null")
		@Length(max = 40, message="title exceeded characters limit")
		String title,
		@NotBlank(message = "description cannot be empty")
		@NotNull(message = "description cannot be null")
		String description,
		@Enumerated(EnumType.STRING)
        Status status) {

}
