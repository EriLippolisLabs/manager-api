package com.eehsantos.manager_api.infrastructure.persistence.repository;

import com.eehsantos.manager_api.domain.model.Task;
import com.eehsantos.manager_api.domain.repository.TaskRepository;
import com.eehsantos.manager_api.infrastructure.mapper.TaskMapper;
import com.eehsantos.manager_api.infrastructure.persistence.SpringDataTaskRepository;
import com.eehsantos.manager_api.infrastructure.persistence.entity.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final SpringDataTaskRepository jpaRepository;

    public TaskRepositoryImpl(SpringDataTaskRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity entity = TaskMapper.toEntity(task);
        TaskEntity saved = jpaRepository.save(entity);
        return TaskMapper.toDomain(saved);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaRepository.findById(id).map(TaskMapper::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(TaskMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
