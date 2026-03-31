package com.TaskTea.Task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(unique = true, nullable = false)
    private String email;


    @Column(unique = true, nullable = false)
    private String username;


    @Column(nullable = false)
    private String password;


    private String role = "USER";

    @CreationTimestamp
    @Column(unique = true)
    private LocalDateTime createdAt;

    public User() {}

    public User(String email, String username, String password, String role){
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
