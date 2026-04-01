package com.TaskTea.Task.controller;

import com.TaskTea.Task.dto.TaskRequest;
import com.TaskTea.Task.entity.Task;
import com.TaskTea.Task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        taskService.createTask(taskRequest);
        String result = taskService.createTask(taskRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllTask(@PathVariable Long userId) {
        taskService.getAllTask(userId);
        List<Task> result = taskService.getAllTask(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable("taskId") Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/tasks/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable("taskId") Long taskId,  @RequestBody TaskRequest taskRequest) {
        Task task = taskService.updateTask(taskId, taskRequest);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
