package com.TaskTea.Task.service;

import com.TaskTea.Task.dto.LoginRequest;
import com.TaskTea.Task.dto.RegisterRequest;
import com.TaskTea.Task.entity.User;
import com.TaskTea.Task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder  passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest registerRequest){
        if(userRepository.findByEmail(registerRequest.getEmail().trim()).isPresent()){
            throw new RuntimeException("Email already exits");
        }

        User user = new User();
        user.setEmail(registerRequest.getEmail().trim());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setUsername(registerRequest.getUsername().trim());
        user.setRole("USER");
        userRepository.save(user);
        return "Registration is Successful";
    }

    public String login(LoginRequest loginRequest){

        User user = userRepository.findByEmail(loginRequest.getEmail().trim())
                .orElseThrow(() -> new RuntimeException("User not found, Register first"));
        String rawPassword = loginRequest.getPassword();
        if(!passwordEncoder.matches(rawPassword, user.getPassword())){
            throw new RuntimeException("Please check your password and try again");
        }
        return "Login Successful";
    }
}
