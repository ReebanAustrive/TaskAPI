package com.TaskTea.Task.repository;

import com.TaskTea.Task.entity.Task;
import com.TaskTea.Task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUser(User user);
    List<Task> findAllTaskStatusByUser(long user, String status);
    void deleteByUser(long user);
}


