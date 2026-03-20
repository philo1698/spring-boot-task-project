package com.project.taskapp.service_layer;

import com.project.taskapp.models.DAO.Task;
import com.project.taskapp.models.DAO.Status;
import com.project.taskapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer handles business logic
 */
@Service // Marks this class as a service component
public class service {
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Create new task
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Delete task by ID
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Get task by ID
     */
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null); // return null if not found
    }

    /**
     * Get all tasks
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Get tasks by list of IDs
     */
    public List<Task> getTasksByIds(List<Long> ids) {
        return taskRepository.findByIdIn(ids);
    }

    /**
     * Update whole task except ID
     */
    public Task updateTask(Long id, Task updatedTask) {
        Task existing = getTaskById(id);

        if (existing == null) return null;

        existing.setTitle(updatedTask.getTitle());
        existing.setDescription(updatedTask.getDescription());
        existing.setStatus(updatedTask.getStatus());
        existing.setAssignedTo(updatedTask.getAssignedTo());

        return taskRepository.save(existing);
    }

    /**
     * Update specific fields
     */
    public Task updateTitle(Long id, String title) {
        Task task = getTaskById(id);
        if (task == null) return null;

        task.setTitle(title);
        return taskRepository.save(task);
    }

    public Task updateDescription(Long id, String description) {
        Task task = getTaskById(id);
        if (task == null) return null;

        task.setDescription(description);
        return taskRepository.save(task);
    }

    public Task updateStatus(Long id, Status status) {
        Task task = getTaskById(id);
        if (task == null) return null;

        task.setStatus(status);
        return taskRepository.save(task);
    }

    public Task updateAssignedTo(Long id, String assignedTo) {
        Task task = getTaskById(id);
        if (task == null) return null;

        task.setAssignedTo(assignedTo);
        return taskRepository.save(task);
    }
}
