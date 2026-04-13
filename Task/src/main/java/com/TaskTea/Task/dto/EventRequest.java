package com.TaskTea.Task.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventRequest {
    private long userId;

    @NotBlank
    private String eventName;

    @NotBlank
    private String description;

    @NotBlank
    private LocalDateTime eventDate;

}
