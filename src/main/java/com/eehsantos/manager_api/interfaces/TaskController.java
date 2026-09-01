package com.eehsantos.manager_api.interfaces;

import com.eehsantos.manager_api.application.service.TaskService;
import com.eehsantos.manager_api.domain.model.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task", description = "Operações relacionadas a tarefas")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Criar tarefa", description = "Cria um nova tarefa no sistema")
    public Task create(@RequestBody Task task) {
        return service.createTask(task);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tarefa por ID", description = "Retorna um tarefa específica pelo seu ID")
    public Optional<Task> getById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @GetMapping
    @Operation(summary = "Buscar todas tarefas", description = "Retorna todas tarefas")
    public List<Task> list() {
        return service.listTasks();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir tarefa por ID", description = "Exclui uma tarefa especifica pelo seu ID")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }

    @PutMapping("/{id}/complete")
    @Operation(summary = "Completa a tarefa por ID", description = "Completa uma tarefa especifica pelo seu ID")
    public Task complete(@PathVariable Long id) {
        return service.completeTask(id);
    }
}

