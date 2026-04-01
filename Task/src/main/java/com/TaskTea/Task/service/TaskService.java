package com.TaskTea.Task.service;

import com.TaskTea.Task.dto.TaskRequest;
import com.TaskTea.Task.entity.Task;
import com.TaskTea.Task.entity.User;
import com.TaskTea.Task.repository.TaskRepository;
import com.TaskTea.Task.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private UserRepository userRepository;

    private TaskRepository taskRepository;

    public TaskService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public String createTask(TaskRequest taskRequest) {
        User user = userRepository.findById(taskRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setUser(user);
        taskRepository.save(task);

        return "Task created successfully";
    }

    public List<Task> getAllTask(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return taskRepository.findAllByUser(user);
    }

    public Task getTaskById(long taskId){
        Task tasks = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return tasks;
    }

    public Task updateTask(long taskId, TaskRequest taskRequest) {
        Task tasks = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        tasks.setTitle(taskRequest.getTitle());
        tasks.setDescription(taskRequest.getDescription());
        tasks.setDueDate(taskRequest.getDueDate());

        taskRepository.save(tasks);

        return tasks;
    }

    public String deleteTask(long taskId){
        Task tasks = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        taskRepository.delete(tasks);

        return "Task deleted successfully";
    }
}
