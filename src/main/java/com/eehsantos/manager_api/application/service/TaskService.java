package com.eehsantos.manager_api.application.service;

import com.eehsantos.manager_api.domain.model.Task;
import com.eehsantos.manager_api.domain.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }


    public Task createTask(Task task) {
        return repository.save(task);
    }


    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }


    public List<Task> listTasks() {
        return repository.findAll();
    }


    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Task completeTask(Long id) {
        Optional<Task> taskOpt = repository.findById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setCompleted(true);
            return repository.save(task);
        }
        throw new RuntimeException("Task não encontrada com id: " + id);
    }
}
