package com.eehsantos.manager_api.infrastructure.persistence;

import com.eehsantos.manager_api.infrastructure.persistence.entity.TaskEntity;
import com.eehsantos.manager_api.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTaskRepository extends JpaRepository<TaskEntity, Long> {
}
