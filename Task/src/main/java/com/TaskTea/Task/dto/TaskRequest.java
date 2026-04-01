package com.TaskTea.Task.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskRequest {

    private long userId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private LocalDateTime dueDate;

}
