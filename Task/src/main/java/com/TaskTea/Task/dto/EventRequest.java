package com.TaskTea.Task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventRequest {
    private Long userId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private LocalDateTime eventDate;

}
