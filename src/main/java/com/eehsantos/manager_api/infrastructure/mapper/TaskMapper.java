package com.eehsantos.manager_api.infrastructure.mapper;

import com.eehsantos.manager_api.domain.model.Task;
import com.eehsantos.manager_api.infrastructure.persistence.entity.TaskEntity;

public class TaskMapper {

    public static TaskEntity toEntity(Task task) {
        TaskEntity entity = new TaskEntity();
        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setCompleted(task.getCompleted());

        if (task.getUser() != null) {
            entity.setUser(UserMapper.toEntity(task.getUser()));
        }

        return entity;
    }

    public static Task toDomain(TaskEntity entity) {
        Task task = new Task();
        task.setId(entity.getId());
        task.setTitle(entity.getTitle());
        task.setDescription(entity.getDescription());
        task.setCompleted(entity.getCompleted());

        if (entity.getUser() != null) {
            task.setUser(UserMapper.toDomain(entity.getUser()));
        }

        return task;
    }
}
