package com.project.taskapp.controllers;

import com.project.taskapp.models.DAO.Task;
import com.project.taskapp.models.DTO.IdListRequest;
import com.project.taskapp.models.DTO.TaskUpdateRequest;
import com.project.taskapp.service_layer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private service taskService;

    /**
     * 1) Create task
     */
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /**
     * 2) Delete task
     */
    @PostMapping("/delete")
    public String deleteTask(@RequestBody Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    /**
     * 3-6) Update fields using body
     */
    @PostMapping("/update/{id}")
    public Task updateTaskFields(@PathVariable Long id,
                                 @RequestBody TaskUpdateRequest request) {

        Task task = taskService.getTaskById(id);
        if (task == null) return null;

        // Update only provided fields
        if (request.getTitle() != null)
            task.setTitle(request.getTitle());

        if (request.getDescription() != null)
            task.setDescription(request.getDescription());

        if (request.getStatus() != null)
            task.setStatus(request.getStatus());

        if (request.getAssignedTo() != null)
            task.setAssignedTo(request.getAssignedTo());

        return taskService.updateTask(id, task);
    }

    /**
     * 7) Update whole task (except ID)
     */
    @PostMapping("/update-full/{id}")
    public Task updateFullTask(@PathVariable Long id,
                               @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    /**
     * 8) Get task by ID
     */
    @PostMapping("/get")
    public Task getTask(@RequestBody Long id) {
        return taskService.getTaskById(id);
    }

    /**
     * 9) Get all tasks
     */
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * 10) Get tasks by list of IDs
     */
    @PostMapping("/list")
    public List<Task> getTasksByIds(@RequestBody IdListRequest request) {
        return taskService.getTasksByIds(request.getIds());
    }
}