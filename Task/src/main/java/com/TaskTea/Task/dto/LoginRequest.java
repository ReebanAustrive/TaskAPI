package com.TaskTea.Task.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class LoginRequest {

    @Getter
    @Setter
    @Email
    @NotBlank
    private String email;

    @Getter
    @Setter
    @NotBlank
    private String password;
}
